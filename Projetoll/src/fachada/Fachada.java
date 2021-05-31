package fachada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import modelo.Conta;
import modelo.ContaEspecial;
import modelo.Correntista;
import modelo.Lancamento;
import repositorio.Repositorio;

public class Fachada {
	
	private static Repositorio repositorio = new Repositorio();

	
	public static ArrayList<Conta> listarContas() {
		ArrayList<Conta> contas = new ArrayList<Conta> (repositorio.getContas().values());
		return contas;
	}
	
	public static ArrayList<Correntista> listarCorrentistas() {
		ArrayList<Correntista> correntistas = new ArrayList<Correntista> (repositorio.getCorrentistas().values());
		return correntistas;
	}
	
	public static ArrayList<Lancamento> listarLancamentos() {
		return repositorio.getLancamentos();
	}
    
	
		
	public static Conta criarConta(String numero, String cpf, String telefone, String email, String nome) throws Exception {
		
		if( repositorio.localizarCorrentista(cpf) != null )
			throw new Exception("Conta já existente.");
		
		Correntista correntista = new Correntista(cpf, nome, telefone, email);
	    repositorio.addCorrentistas(correntista);
	    	
	    Conta conta = new Conta(numero, correntista);
	    correntista.setConta(conta);
	    return conta;
	        
    }
    
    public static ContaEspecial criarConta(String numero, double limite, String cpf, String telefone, String email, String nome) throws Exception {
    	
    	if( repositorio.localizarCorrentista(cpf) != null )
			throw new Exception("Conta já existente.");
    	if( limite < 0 )
    		throw new Exception("Limite não pode ser negativo.");
    	
    	Correntista correntista = new Correntista(cpf, nome, telefone, email);
    	repositorio.addCorrentistas(correntista);
    	
        ContaEspecial conta = new ContaEspecial(numero, 0, null, null, new ArrayList<>(), correntista, limite);
        correntista.setConta(conta);
            	
        return conta;
    }
    
    public static void criarChave(String cpf, String tipochavePiks) {
    	Correntista correntista = repositorio.localizarCorrentista(cpf);
    	Conta conta = correntista.getConta();
    	Random r = new Random();
    	
    	String oldKey = conta.getChavePIKS();
    	    		
    	if (tipochavePiks == "cpf")
    		conta.setChavePIKS(correntista.getCpf());
    	else if (tipochavePiks == "email")
    		conta.setChavePIKS(correntista.getEmail());
    	else if (tipochavePiks == "telefone")
    		conta.setChavePIKS(correntista.getTelefone());
    	else if (tipochavePiks == "aleatorio")
    		while(true) {
    			String number = Integer.toString( r.nextInt(89999999) + 10000000 );
    			Conta contaPix = repositorio.getContas().get(number);
    			if(contaPix == null) {
    				conta.setChavePIKS(number);
    				break;
    			}
    		}
    	
    	List<String> tipos = Arrays.asList("cpf", "email", "telefone", "aleatorio");
    	
    	if(tipos.contains(tipochavePiks))
    		conta.setTipochavePiks(tipochavePiks);
    	
    	if(oldKey == null)
    		repositorio.addContas(conta);
    }
    
    public static void criarChavePIKS(String cpf, String tipochavePiks) {
    	criarChave(cpf, tipochavePiks);
    }
    
    
    public static void apagarConta(String cpf) throws Exception {
    	
    	Correntista correntista = repositorio.localizarCorrentista(cpf);
    	
    	if(correntista == null)
    		throw new Exception("Conta inexistente.");
    	
    	Conta conta = correntista.getConta();
    	
    	if(conta.getSaldo() > 0)
    		throw new Exception("Saldo na conta não é zero.");
    	
    	for(Lancamento lancamento : conta.getLancamentos())
    		repositorio.delLancamentos(lancamento);
    	
    	if(conta.getChavePIKS() != null)
    		repositorio.delContas(conta);
    	
    	repositorio.getCorrentistas().remove(cpf);
    }
    
    // metodo apagar que é chamado em AplicacaoConsole1.java
    public static void apagar(String cpf) throws Exception {
    	apagarConta(cpf);
    }
    
    public static Conta obterConta(String cpf) {
    	Conta conta = repositorio.localizarCorrentista(cpf).getConta();
    	return conta;
    }
    
    public static Conta obterContaTop() {
    	Conta contaTop = null;
    	int top = 0;
    	    	
    	for( Conta conta : listarContas() ) {
    		int lenLancamento = conta.getLancamentos().toArray().length;
    		if( lenLancamento >= top ) {
    			top = lenLancamento;
    			contaTop = conta;
    		}
    	}
    	return contaTop;
    }
    
    public static void creditar(String cpf, double valor) throws Exception {
    	Conta conta = repositorio.localizarCorrentista(cpf).getConta();
    	if(valor < 0)
    		conta.debitar(valor);
    	else
    		conta.creditar(valor);
    }
 
    
    public static void transferir(String cpf, String chavePIKS, double quantia) throws Exception {
    	Correntista origem = repositorio.localizarCorrentista(cpf);
    	Conta destino = repositorio.localizarConta(chavePIKS);
    	
    	if( destino == null )
    		throw new Exception("Chave inexistente.");
    	if( origem == null )
    		throw new Exception("Conta de origem inexistente.");
    	if( origem.getConta() == destino )
    		throw new Exception("Conta destino igual a conta origem.");
    	if( quantia < 0 )
    		throw new Exception("Valor não pode ser negativo.");
    	
    	Conta contaOrigem = origem.getConta();
    	repositorio.addLancamentos( contaOrigem.criarLancamento( destino.getNumero(),-quantia ) );
    	repositorio.addLancamentos( destino.criarLancamento( contaOrigem.getNumero(),quantia ) );
    	contaOrigem.debitar(quantia);
    	destino.creditar(quantia);
    }
}
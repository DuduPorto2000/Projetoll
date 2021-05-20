package Fachada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import Banco.Conta;
import Banco.ContaEspecial;
import Banco.Correntista;
import Banco.Lancamento;

import Repositorio.Repositorio;

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
    
	
	
	
	
	public static Conta criarConta(String numero, String cpf, String telefone, String email, String nome) {
    	
    	Correntista correntista = new Correntista(cpf, nome, telefone, email);
    	repositorio.addCorrentistas(correntista);
    	
        Conta conta = new Conta(numero, correntista);
        
        return conta;
    }
    
    public static ContaEspecial criarConta(String numero, String cpf, String telefone, String email, String nome, double limite) {
    	
    	Correntista correntista = new Correntista(cpf, nome, telefone, email);
    	repositorio.addCorrentistas(correntista);
    	
        ContaEspecial conta = new ContaEspecial(numero, 0, null, null, new ArrayList<>(), correntista, limite);
    	
        return conta;
    }
    
    public static void criarChave(String cpf, String tipochavePiks) {
    	Correntista correntista = repositorio.localizarCorrentista(cpf);
    	Conta conta = correntista.getConta();
    	Random r = new Random();
    	    		
    	if (tipochavePiks == "cpf")
    		conta.setChavePiks(correntista.getCpf());
    	else if (tipochavePiks == "email")
    		conta.setChavePiks(correntista.getEmail());
    	else if (tipochavePiks == "telefone")
    		conta.setChavePiks(correntista.getTelefone());
    	else if (tipochavePiks == "aleatorio")
    		while(true) {
    			String number = Integer.toString( r.nextInt(89999999) + 10000000 );
    			Conta contaPix = repositorio.getContas().get(number);
    			if(contaPix == null) {
    				conta.setChavePiks(number);
    				break;
    			}
    		}
    	List<String> tipos = Arrays.asList("cpf", "email", "telefone", "aleatorio");
    	if(tipos.contains(tipochavePiks)) {
    		conta.setTipochavePiks(tipochavePiks);
    	}
    	repositorio.addContas(conta);
    }
    
    
    
    
    
    public void apagarConta(String cpf) {
    	Correntista correntista = repositorio.localizarCorrentista(cpf);
    	Conta conta = correntista.getConta();
    	for(Lancamento lancamento : conta.getLancamentos()) {
    		repositorio.delLancamentos(lancamento);
    	}
    	if(conta.getChavePiks() != null)
    		repositorio.delContas(conta);
    	repositorio.getCorrentistas().remove(cpf);
    }
    
}
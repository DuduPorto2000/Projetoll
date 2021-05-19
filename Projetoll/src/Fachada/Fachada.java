package Fachada;

import java.util.ArrayList;
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
        repositorio.addContas(conta);
        
        return conta;
    }
    
    public static ContaEspecial criarConta(String numero, double limite, String cpf,
    		String telefone, String email, String nome) {
    	
    	Correntista correntista = new Correntista(cpf, nome, telefone, email);
    	repositorio.addCorrentistas(correntista);
    	
        ContaEspecial conta = new ContaEspecial(numero, limite, 0, null, null, new ArrayList<>(), correntista);
        repositorio.addContas(conta);
    	
        return conta;
    }
    
    public static void criarChave(String cpf, String tipochavePiks) {
    	Conta conta = localizarConta(cpf);
    	Random r = new Random();
    	    		
    	if (tipochavePiks == "cpf")
    		conta.setChavePiks(conta.getCorrentista().getCpf());
    	else if (tipochavePiks == "email")
    		conta.setChavePiks(conta.getCorrentista().getEmail());
    	else if (tipochavePiks == "telefone")
    		conta.setChavePiks(conta.getCorrentista().getTelefone());
    	else if (tipochavePiks == "aleatorio")
    		while(true) {
    			String number = Integer.toString( r.nextInt(89999999) + 10000000 );
    			Conta contaPix = localizarPix(number);
    			
    			if( contaPix == null ) {
    				conta.setChavePiks(number);
    				break;
    			}
    		}
    		
    	
    	for (String chave :  new String[] {"cpf", "email", "telefone", "aleatorio"} ) {
    		if(tipochavePiks == chave) {
    			conta.setTipochavePiks(tipochavePiks);
    			break;
    		}
    	}
    	
    }
    
    public static Conta localizarPix(String key) {
    	
    	Conta contaPix = null;
    	for(Conta conta : repositorio.getContas().values()) {
    		if(conta.getChavePiks() == key) {
    			contaPix = conta;
    			break;
    		}
    	}
    	
    	return contaPix;
    }
    
	public static Conta localizarConta(String cpf) {
		return repositorio.getContas().get(cpf);
	}
}

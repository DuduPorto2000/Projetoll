package Repositorio;

import java.util.ArrayList;

import java.util.TreeMap;

import Banco.Conta;
import Banco.Correntista;
import Banco.Lancamento;

public class Repositorio {
	private TreeMap<String, Correntista> correntistas = new TreeMap<>();
	private TreeMap<String, Conta> contas = new TreeMap<>();
	private ArrayList<Lancamento> lancamentos = new ArrayList<>();
	
	
	
	
	public void addCorrentistas(Correntista correntista) {
		this.correntistas.put(correntista.getCpf(), correntista);
	}
	public void delCorrentista(Correntista correntista) {
		this.correntistas.remove(correntista.getCpf());
	}
	public Correntista localizarCorrentista(String Cpf) {
		return correntistas.get(Cpf);
	}
	
	
	
	
	public void addContas(Conta conta) {
		this.contas.put(conta.getChavePiks(), conta);
	}
	public void delContas(Conta conta) {
		this.contas.remove(conta.getChavePiks());
	}
	public Conta localizarConta(String chavePiks) {
		return contas.get(chavePiks);
	}
	
	
	
	
	
	
	public void addLancamentos(Lancamento lancamento) {
		this.lancamentos.add(lancamento);
	}
	
	public void delLancamentos(Lancamento lancamento) {
		this.lancamentos.remove(lancamento);
	}
	
	
	
	
	
	public TreeMap<String, Correntista> getCorrentistas() {
		return correntistas;
	}
	
	public TreeMap<String, Conta> getContas() {
		return contas;
	}
	
	
	public ArrayList<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
	
	
	
	
	public int getTotalContas(){
		return contas.size();
	}
	
	public int getTotalCorrentistas(){
		return correntistas.size();
	}
	
	public int getTotalLancamentos(){
		return lancamentos.size();
	}
}

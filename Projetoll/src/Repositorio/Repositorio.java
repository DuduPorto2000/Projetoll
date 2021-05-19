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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public TreeMap<String, Correntista> getCorrentistas() {
		return correntistas;
	}
	
	public void setCorrentistas(TreeMap<String, Correntista> correntistas) {
		this.correntistas = correntistas;
	}
	
	public TreeMap<String, Conta> getContas() {
		return contas;
	}
	
	public void setContas(TreeMap<String, Conta> contas) {
		this.contas = contas;
	}
	
	public ArrayList<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
	public void setLancamentos(ArrayList<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
}

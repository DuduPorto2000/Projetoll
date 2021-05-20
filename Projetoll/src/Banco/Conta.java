package Banco;

import java.util.ArrayList;

public class Conta {
	private String numero;
	private double saldo;
	private String chavePiks;
	private String tipochavePiks;
	private ArrayList<Lancamento> lancamentos;
	private Correntista correntista;

	
	
	
	
	public Conta (String numero, Correntista correntista) {
		setNumero(numero);
		setSaldo(0);
		setLancamentos(new ArrayList<>());
		setCorrentista(correntista);
	}
	
	public Conta (String numero, double saldo, String chavePiks, String tipochavePiks, ArrayList<Lancamento> lancamentos, Correntista correntista) {
		setNumero(numero);
		setSaldo(saldo);
		setChavePiks(chavePiks);
		setTipochavePiks(tipochavePiks);
		setLancamentos(lancamentos);
		setCorrentista(correntista);
	}
		
	
	public void creditar(String cpf, double valor) {
		
	}
	

	public String getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public String getChavePiks() {
		return chavePiks;
	}
	
	public String getTipochavePiks() {
		return tipochavePiks;
	}
	
	public ArrayList<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
	public Correntista getCorrentista() {
		return correntista;
	}

	
	
	
	
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void setChavePiks(String chavePiks) {
		this.chavePiks = chavePiks;
	}
	
	
	public void setTipochavePiks(String tipochavePiks) {
		this.tipochavePiks = tipochavePiks;
	}

	public void setLancamentos(ArrayList<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}
}

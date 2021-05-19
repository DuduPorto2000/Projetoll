package Banco;

import java.util.ArrayList;

public class Conta {
	private String numero;
	private double saldo;
	private String chavePiks;
	private String tipochavePiks;
	private ArrayList<Lancamento> lancamentos = new ArrayList<>();
	private Correntista correntista;
	
		
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getChavePiks() {
		return chavePiks;
	}

	public void setChavePiks(String chavePiks) {
		this.chavePiks = chavePiks;
	}

	public String getTipochavePiks() {
		return tipochavePiks;
	}

	public void setTipochavePiks(String tipochavePiks) {
		this.tipochavePiks = tipochavePiks;
	}

	public ArrayList<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(ArrayList<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Correntista getCorrentista() {
		return correntista;
	}

	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}
}

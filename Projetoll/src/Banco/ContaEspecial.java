package Banco;

import java.util.ArrayList;

public class ContaEspecial extends Conta {
	private double limite;


	
	
	public ContaEspecial(String numero, double saldo, String chavePiks, String tipochavePiks,
			ArrayList<Lancamento> lancamentos, Correntista correntista, double limite) {
		super(numero, saldo, chavePiks, tipochavePiks, lancamentos, correntista);
		setLimite(limite);
	}

	

	
	
	public double getLimite() {
		return limite;
	}

	
	
	
	
	public void setLimite(double limite) {
		this.limite = limite;
	}
}
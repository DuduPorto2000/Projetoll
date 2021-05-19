package Banco;

import java.util.ArrayList;

public class ContaEspecial extends Conta {
	private double limite;


	public ContaEspecial(String numero, double limite, double saldo, String chavePiks, String tipochavePiks,
			ArrayList<Lancamento> lancamentos, Correntista correntista) {
		super(numero, saldo, chavePiks, tipochavePiks, lancamentos, correntista);
		// TODO Auto-generated constructor stub
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
}
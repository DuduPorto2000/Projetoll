package modelo;

import java.util.ArrayList;

public class ContaEspecial extends Conta {
	private double limite;
	
	
	public ContaEspecial(String numero, double saldo, String chavePiks, String tipochavePiks,
			ArrayList<Lancamento> lancamentos, Correntista correntista, double limite) {
		super(numero, saldo, chavePiks, tipochavePiks, lancamentos, correntista);
		setLimite(limite);
	}
	
	@Override
	public void debitar(double valor) throws Exception {
		if( getSaldo() + getLimite() >= valor )
			setSaldo( getSaldo() - valor );
		else
			throw new Exception("Credito insuficiente");
	}
	
	@Override
	public String toString() {

		return "ContaEspecial [numero=" + getNumero() + ", saldo=" + getSaldo() + ", chavePIKS=" + getChavePIKS() + ", tipochavePiks="
				+ getTipochavePiks() + ", correntistaCPF=" + getCorrentista().getCpf() + ", limite=" + getLimite() + "]";
	}

	public double getLimite() {
		return limite;
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}
}
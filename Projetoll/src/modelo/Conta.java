package modelo;

import java.util.ArrayList;

public class Conta {
	private String numero;
	private double saldo;
	private String chavePIKS;
	private String tipochavePiks;
	private ArrayList<Lancamento> lancamentos;
	private Correntista correntista;
	
	public Conta (String numero, Correntista correntista) {
		setNumero(numero);
		setSaldo(0);
		setLancamentos(new ArrayList<>());
		setCorrentista(correntista);
	}
	
	public Conta (String numero, double saldo, String chavePIKS, String tipochavePiks, ArrayList<Lancamento> lancamentos, Correntista correntista) {
		setNumero(numero);
		setSaldo(saldo);
		setChavePIKS(chavePIKS);
		setTipochavePiks(tipochavePiks);
		setLancamentos(lancamentos);
		setCorrentista(correntista);
	}
	
	public void creditar(double valor) {
		setSaldo( getSaldo() + valor );
	}
	
	public void debitar(double valor) throws Exception {
		if( getSaldo() >= valor )
			setSaldo( getSaldo() - valor );
		else
			throw new Exception("Credito insuficiente");
	}
	
	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + ", chavePIKS=" + chavePIKS + ", tipochavePiks="
				+ tipochavePiks + ", correntistaCPF=" + correntista.getCpf() + "]";
	}

	public Lancamento criarLancamento(String numero, double valor) {
		Lancamento lancamento = new Lancamento(numero, valor);
		getLancamentos().add(lancamento);
		
		return lancamento;
	}
	
	
	public String getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public String getChavePIKS() {
		return chavePIKS;
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
	
	public void setChavePIKS(String chavePiks) {
		this.chavePIKS = chavePiks;
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

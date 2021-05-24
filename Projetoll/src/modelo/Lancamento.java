package modelo;

import java.time.LocalDateTime;

public class Lancamento {
	private LocalDateTime datahora;
	private double valor;
	private String numero;
	
	
	public Lancamento (String numero, double valor) {
		setDatahora(LocalDateTime.now());
		setValor(valor);
		setNumero(numero);
	}
	
	
	@Override
	public String toString() {
		return "Lancamento [datahora=" + datahora + ", valor=" + valor + ", numero=" + numero + "]";
	}

	public LocalDateTime getDatahora() {
		return datahora;
	}
	
	public double getValor() {
		return valor;
	}
	
	public String getNumero() {
		return numero;
	}
	
	
	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}

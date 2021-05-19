package Banco;

import java.time.LocalDateTime;

public class Lancamento {
	private LocalDateTime datahora;
	private double valor;
	private String numero;
	

	public LocalDateTime getDatahora() {
		return datahora;
	}
	
	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}

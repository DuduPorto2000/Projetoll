package Banco;

import java.time.LocalDateTime;

public class Lancamento {
	private LocalDateTime datahora;
	private double valor;
	private String numero;
	
	
	
	
	
	public Lancamento () {
		setDatahora(LocalDateTime.now());
		setValor(valor);
		setNumero(numero);
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

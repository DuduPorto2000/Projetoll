package Banco;

public class Correntista {
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private Conta conta;
	

	public Correntista(String cpf, String nome, String telefone, String email) {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEmail(email);
	}
	

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}

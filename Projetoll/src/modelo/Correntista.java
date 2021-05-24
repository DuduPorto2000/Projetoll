package modelo;

public class Correntista {
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private Conta conta;
	
	
	public Correntista(String cpf, String nome, String telefone, String email) {
		setCpf(cpf);
		setNome(nome);
		setTelefone(telefone);
		setEmail(email);
	}
	

	@Override
	public String toString() {
		return "Correntista [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", contaNumero="
				+ conta.getNumero() + "]";
	}


	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Conta getConta() {
		return conta;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}

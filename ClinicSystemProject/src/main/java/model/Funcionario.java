package model;

public abstract class Funcionario extends Pessoa {
	
	private String login;
	private String senha;
	
	public Funcionario(String nome, String telefone, String email, String cpf, String login, String senha) {
		
		super(nome, telefone, email, cpf);
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
}

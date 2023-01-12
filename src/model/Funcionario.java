package model;

public abstract class Funcionario extends Pessoa {
	
	private String login;
	private String senha;
	private String matricula;
	
	public Funcionario(String nome, String telefone, String email, String cpf, String login, String senha, String matricula) {
		
		super(nome, telefone, email, cpf);
		this.login = login;
		this.matricula = matricula;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
}

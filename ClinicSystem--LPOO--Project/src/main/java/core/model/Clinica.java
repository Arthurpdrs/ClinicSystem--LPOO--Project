package core.model;

public class Clinica {
	private String Nome;
	private String Email;
	private String Senha;
	private String Telefone;
	private String Endereco;
	
	public Clinica(String nome, 
			String email, 
			String senha, 
			String telefone, 
			String endereco) {
		
		this.Nome = nome;
		this.Email = email;
		this.Senha = senha;
		this.Telefone = telefone;
		this.Endereco = endereco;
	}

	public Clinica () {}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getSenha() {
		return Senha;
	}
	
	public void setSenha(String senha) {
		Senha = senha;
	}
	
	public String getTelefone() {
		return Telefone;
	}
	
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	
	public String getEndereco() {
		return Endereco;
	}
	
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	
	
}

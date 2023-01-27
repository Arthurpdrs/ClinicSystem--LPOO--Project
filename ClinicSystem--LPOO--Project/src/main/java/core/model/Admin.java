package core.model;

public class Admin extends Funcionario {
	
	public Admin(String nome, String telefone, String email, String cpf, String login, String senha) {
		super(nome, telefone, email, cpf, login, senha);
	}

	public void cadastrarProfissional() {}
	public void mostrarProfissionais() {}

}

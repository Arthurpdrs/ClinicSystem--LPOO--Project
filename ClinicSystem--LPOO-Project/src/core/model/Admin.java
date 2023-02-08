package core.model;

public class Admin extends Funcionario {
	
	private final Integer id = 1;

	public Admin(String nome, String telefone, String email, String cpf, String login, String senha) {
		super(nome, telefone, email, cpf, login, senha);
	}
	
	public Admin() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

}

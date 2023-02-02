package core.model;

public class Recepcionista extends Funcionario{
	
	private final Integer id = 3;
	
	public Recepcionista(String nome, String telefone, String email, String cpf, String login, String senha) {
		super(nome, telefone, email, cpf, login, senha);
	}

	public Integer getId() {
		return id;
	}

	
}

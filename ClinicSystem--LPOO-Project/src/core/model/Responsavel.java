package core.model;





public class Responsavel extends Pessoa{

	public Responsavel(String nome, String telefone, String email, String cpf) {
		super(nome, telefone, email, cpf);
		
	}
	
	public Responsavel(String nome, String cpf, String telefone) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setTelefone(telefone);
	}
	
	public Responsavel () {
		
	}

}

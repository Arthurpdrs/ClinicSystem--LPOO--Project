package core.model;

public class Medico extends Funcionario{
	
	private String crm;
	private String especialidade;
	
	
	
	public Medico(String nome, String telefone, String email, String cpf,
			String login, String senha,
			String crm, String especialidade) {
		
		super(nome, telefone, email, cpf, login, senha);
		this.crm = crm;
		this.especialidade = especialidade;
		
	}
	
	public Medico() {
		super();
	}



	public String getCrm() {
		return crm;
	}



	public void setCrm(String crm) {
		this.crm = crm;
	}



	public String getEspecialidade() {
		return especialidade;
	}



	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	
}

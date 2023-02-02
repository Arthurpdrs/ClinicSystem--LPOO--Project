package core.model;

import java.util.Date;

public class Paciente extends Pessoa{
	
	private String tipoSanguineo;
	private String alergia;
	private String dataNascimento;
	private Responsavel responsavel;
	private String endereco;

	public Paciente(
			String nome,
			String telefone,
			String email,
			String cpf,
			String tipoSanguineo,
			String alergia,
			String dataNascimento,
			String endereco) {
		super(nome, telefone, email, cpf);
		this.tipoSanguineo = tipoSanguineo;
		this.alergia = alergia;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}
	
	public Paciente() {
		super();
	}


	public String getTipoSanguineo() {
		return tipoSanguineo;
	}


	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}


	public String getAlergia() {
		return alergia;
	}


	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Responsavel getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	

}

package model;

import java.util.Date;

public class Paciente extends Pessoa{
	
	private String tipoSanguineo;
	private String alergia;
	private Date dataNascimento;
	private String responsavel;
	private Endereco endereco;
	

	public Paciente(
			String nome,
			String telefone,
			String email,
			String cpf,
			String tipoSanguineo,
			String alergia,
			Date dataNascimento,
			Endereco endereco) {
		super(nome, telefone, email, cpf);
		this.tipoSanguineo = tipoSanguineo;
		this.alergia = alergia;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
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


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}

package model;

import java.util.Date;



public class Prontuario {
	private String queixa;
	private String prescricao;
	private Date data;
	private Medico medico;
	private Paciente paciente;
	
	public Prontuario(
			String queixa,
			String prescricao,
			Date data,
			Medico medico,
			Paciente paciente) {
		
		this.queixa = queixa;
		this.prescricao = prescricao;
		this.data = data;
		this.medico = medico;
		this.paciente = paciente;
	}

	public String getQueixa() {
		return queixa;
	}

	public void setQueixa(String queixa) {
		this.queixa = queixa;
	}

	public String getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(String prescricao) {
		this.prescricao = prescricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	
	

}

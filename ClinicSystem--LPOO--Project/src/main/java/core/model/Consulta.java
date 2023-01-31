package core.model;

import java.sql.Time;
import java.util.Date;

public class Consulta {
	private Date dataConsulta;
	private Time horario;
	private Medico medico;
	private Paciente paciente;
	private Double valor;
	private Boolean pago;
	

	public Consulta(
			Date dataConsulta,
			String horario,
			Medico medico,
			Paciente paciente,
			Double valor,
			Boolean pago) {

		this.dataConsulta = dataConsulta;
		this.medico = medico;
		this.paciente = paciente;
		this.valor = valor;
		this.pago = pago;
	}
	
	public Consulta() {}


	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
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


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Boolean getPago() {
		return pago;
	}


	public void setPago(Boolean pago) {
		this.pago = pago;
	}
	
	
	
	
	
	

}

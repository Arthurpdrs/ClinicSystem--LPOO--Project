package core.model;


public class Consulta {
	private String dataConsulta;
	private String horario;
	private Medico medico;
	private Paciente paciente;
	private String valor;
	private String pago;
	private String totalConsulta;
	

	public Consulta(
			String dataConsulta,
			String horario,
			Medico medico,
			Paciente paciente,
			String valor,
			String pago,
			String totalConsulta) {

		this.dataConsulta = dataConsulta;
		this.medico = medico;
		this.paciente = paciente;
		this.valor = valor;
		this.pago = pago;
		this.totalConsulta = totalConsulta;
	}
	
	public Consulta() {}


	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
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


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public String getPago() {
		return pago;
	}


	public void setPago(String pago) {
		this.pago = pago;
	}
	
	public String getTotalConsulta() {
		return totalConsulta;
	}

	public void setTotalConsulta(String totalConsulta) {
		this.totalConsulta = totalConsulta;
	}

	
	
	
	
	
	

}

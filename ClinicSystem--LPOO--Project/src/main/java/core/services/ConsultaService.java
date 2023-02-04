package core.services;

import java.sql.SQLException;

import core.model.Consulta;
import core.model.Medico;
import core.model.Paciente;
import core.model.Responsavel;
import dao.ConsultaDAO;

public class ConsultaService {
	
	public boolean inserir(String nome, String telefone, String cpf, String email, String horario, String valor, String observacao, String estadoPagamento, String cpfResponsavel, String cpfMedico, String data) throws SQLException {
		Consulta consulta = new Consulta();
		Paciente paciente = new Paciente();
		Responsavel responsavel = new Responsavel();
		Medico medico = new Medico();
		
		medico.setCpf(cpfMedico);
		consulta.setMedico(medico);
		responsavel.setCpf(cpfResponsavel);
		paciente.setResponsavel(responsavel);
		paciente.setCpf(cpf);
		paciente.setEmail(email);
		consulta.setValor(valor);
		consulta.setHorario(horario);
		consulta.setPago(estadoPagamento);
		consulta.setPaciente(paciente);
		consulta.setDataConsulta(data);
		
		if (!(TextFieldService.validarEmail(email)) || !(TextFieldService.validarHorario(horario)) || cpfMedico.isBlank() || nome.isBlank() || cpf.isBlank() || telefone.isBlank() || !(TextFieldService.validarData(data)) || valor.isBlank()) {
			return false;
		} else {
			ConsultaDAO consultaDAO = new ConsultaDAO();
			consultaDAO.inserir(consulta);
			return true;
		}
	}

}

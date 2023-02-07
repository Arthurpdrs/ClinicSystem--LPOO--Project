package core.services;

import java.sql.SQLException;

import core.model.Medico;
import core.model.Paciente;
import core.model.Prontuario;
import dao.ProntuarioDAO;

public class ProntuarioService {
	public boolean inserir(String queixa, String observacao, String data_prontuario, String Prescricao,  String paciente_cpf, String paciente_nome, String nome_medico, String especialidade) throws SQLException {
		if (queixa.isBlank() || observacao.isBlank() || data_prontuario.isBlank() || Prescricao.isBlank()  || paciente_cpf.isBlank()|| paciente_nome.isBlank() || !(TextFieldService.validarData(data_prontuario)) || !(TextFieldService.validarNumero(paciente_cpf))) {
			return false;
		}
		else {
			ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
			Prontuario prontuario = new Prontuario();
			Medico medico = new Medico();
			Paciente paciente = new Paciente();
			prontuario.setData(data_prontuario);
			prontuario.setQueixa(queixa);
			prontuario.setObservacao(observacao);
			medico.setNome(nome_medico);;
			medico.setEspecialidade(especialidade);
			prontuario.setPrescricao(Prescricao);
			paciente.setNome(paciente_nome);
			paciente.setCpf(paciente_cpf);
			prontuario.setPaciente(paciente);
			prontuario.setMedico(medico);
			prontuarioDAO.inserir(prontuario);			
			return true;		
		}
	}
	
}

package core.services;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	
	public boolean visualizarProntuarios(JTable jtable) throws SQLException {
		DefaultTableModel model = (DefaultTableModel) jtable.getModel();
		ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
		List<Prontuario> prontuarios = prontuarioDAO.listar();
		
	     model.setNumRows(0);
		if (prontuarios.size() > 0) {
			for (Prontuario prontuario : prontuarios) {
					model.addRow(new Object[] {
							prontuario.getPaciente().getNome(),
							prontuario.getPaciente().getCpf(),
							prontuario.getMedico().getNome(),
							prontuario.getMedico().getEspecialidade(),
							prontuario.getData(),
							prontuario.getQueixa(),
							prontuario.getPrescricao(),
							prontuario.getObservacao()
					});
				}
				jtable.setModel(model);
				return true;
			} 
		return false;
}
	public boolean filtrar(JTable jtable, String cpf) throws SQLException {
		if (TextFieldService.validarNumero(cpf)) {
		DefaultTableModel model = (DefaultTableModel) jtable.getModel();
		ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
		List<Prontuario> prontuarios = prontuarioDAO.filtrar(cpf);
		
	     model.setNumRows(0);
		if (prontuarios.size() > 0) {
			for (Prontuario prontuario : prontuarios) {
					model.addRow(new Object[] {
							prontuario.getPaciente().getNome(),
							prontuario.getPaciente().getCpf(),
							prontuario.getMedico().getNome(),
							prontuario.getMedico().getEspecialidade(),
							prontuario.getData(),
							prontuario.getQueixa(),
							prontuario.getPrescricao(),
							prontuario.getObservacao()
					});
				}
				jtable.setModel(model);
				return true;
			} 
		}
		return false;
}
}

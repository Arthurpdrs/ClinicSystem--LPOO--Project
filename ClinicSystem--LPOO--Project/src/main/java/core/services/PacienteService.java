package core.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import core.model.Paciente;
import dao.PacienteDAO;

public class PacienteService {
	
	public boolean visualizarPacientes(JTable jtable) throws SQLException {
			DefaultTableModel model = (DefaultTableModel) jtable.getModel();
			PacienteDAO pacienteDAO = new PacienteDAO();
			List<Paciente> pacientes = pacienteDAO.listarPacientes();
			
                        model.setNumRows(0);
			if (pacientes.size() > 0) {
				for (Paciente paciente : pacientes) {
						model.addRow(new Object[] {
								paciente.getNome(),
								paciente.getEndereco(),
								paciente.getCpf(),
								paciente.getEmail(),
								paciente.getTelefone(),
								paciente.getTipoSanguineo(),
								paciente.getAlergia(),
								paciente.getObservacao(),
								paciente.getDataNascimento(),
								paciente.getResponsavel().getNome(),
								paciente.getResponsavel().getTelefone(),
								paciente.getResponsavel().getCpf()
								
						});
					}
					jtable.setModel(model);
					return true;
				} 
			return false;
	}
	
	public void cadastrar(String nome, String telefone, String email, String cpf,
			String tipoSanguineo, String alergia, String dataNascimento, String endereco, String observacao) throws SQLException {
		
		Paciente paciente = new Paciente(nome, telefone, email, cpf, tipoSanguineo, alergia,dataNascimento, endereco, observacao);
		
		if(verificarDadosObrigatorios(paciente)) {
			PacienteDAO pacienteDao = new PacienteDAO();
			pacienteDao.addPaciente(paciente, null);
		}
			
	}
	
	private boolean verificarDadosObrigatorios(Paciente paciente) {
		
		List<String> dadosObrigatorios = new ArrayList<String>();
		dadosObrigatorios.add(paciente.getNome());
		dadosObrigatorios.add(paciente.getTelefone());
		dadosObrigatorios.add(paciente.getEmail());
		dadosObrigatorios.add(paciente.getCpf());
		
		for(String dado : dadosObrigatorios) {
			
			if(dado.isBlank()) {
				return false;
			}
		}
		
		return true;
	}
}

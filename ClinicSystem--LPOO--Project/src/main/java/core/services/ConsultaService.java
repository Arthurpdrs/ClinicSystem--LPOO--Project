package core.services;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import core.model.Consulta;
import core.model.Medico;
import core.model.Paciente;
import core.model.Responsavel;
import dao.ConsultaDAO;
import dao.PacienteDAO;
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
	
	public boolean visualizarConsultas(JTable jtable) throws SQLException {
		DefaultTableModel model = (DefaultTableModel) jtable.getModel();
		ConsultaDAO consultaDAO = new ConsultaDAO();
		List<Consulta> consultas = consultaDAO.listar();
		
         model.setNumRows(0);
		if (consultas.size() > 0) {
			for (Consulta consulta : consultas) {
					model.addRow(new Object[] {
							consulta.getPaciente().getNome(),
							consulta.getPaciente().getEmail(),
							consulta.getPaciente().getCpf(),
							consulta.getPaciente().getObservacao(),
							consulta.getMedico().getEspecialidade(),
							consulta.getMedico().getNome(),
							consulta.getDataConsulta(),
							consulta.getHorario(),
							consulta.getValor(),
							consulta.getPago(),
							consulta.getId()
							
					});
				}
				jtable.setModel(model);
				return true;
			} 
		return false;
}
	
	public String totalConsultasDia() throws SQLException {
		Consulta consulta = new Consulta();
		ConsultaDAO consultadao = new ConsultaDAO();
		
		consulta.setTotalConsulta(consultadao.TotalConsultas());
		return consulta.getTotalConsulta();
		}
	
	public boolean horariosConsultas(JTable jtable, String dataAtual) throws SQLException {
		if (System.getProperty("cargo") == (null) || System.getProperty("cpf_logado") == (null)) {
			return false;
		} else {
			if (System.getProperty("cargo").equals("MEDICO")){
				return false;
			}
			String cpf = System.getProperty("cpf_logado");
			DefaultTableModel model = (DefaultTableModel) jtable.getModel();
			ConsultaDAO consultaDAO = new ConsultaDAO();
			List<String> horarios = consultaDAO.filtrarMedicoEData(cpf, dataAtual);
			
	        model.setNumRows(0);
			if (horarios.size() > 0) {
				for (String horario : horarios) {
						model.addRow(new Object[] {
								horario
						});
					}
				jtable.setModel(model);
				return true;
			} else {
				return false;
			}
		}
		
	}
	
	public boolean remover(int id) throws SQLException {
		if (id == 0) {
			return false;
		} else {
			ConsultaDAO consultaDAO = new ConsultaDAO();
			consultaDAO.remover(id);
			return true;
		}
	}
	
	
	
}

package core.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import core.model.Medico;
import core.model.Paciente;
import core.model.Responsavel;
import dao.MedicoDAO;
import dao.PacienteDAO;
import dao.ResponsavelDAO;

public class PacienteService {
	
	public boolean visualizarPacientes(JTable jtable) throws SQLException {
			DefaultTableModel model = (DefaultTableModel) jtable.getModel();
			PacienteDAO pacienteDAO = new PacienteDAO();
			List<Paciente> pacientes = pacienteDAO.listar();
			
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
	
	public boolean filtrar(JTable jtable, String cpf) throws SQLException {
		if (cpf.isBlank() || (TextFieldService.validarNumero(cpf) == false)) {
			return false;
		} else {
			DefaultTableModel model = (DefaultTableModel) jtable.getModel();
			PacienteDAO pacienteDAO = new PacienteDAO();
			List<Paciente> pacientes = pacienteDAO.filtrar(cpf);
			
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
		}
			return false;
	}
	
	public Paciente retornarPacienteFiltrado(String cpf) throws SQLException {
		if (cpf.isBlank() || (TextFieldService.validarNumero(cpf) == false)) {
			return null;
		} else {
			PacienteDAO pacienteDAO = new PacienteDAO();
			List<Paciente> pacientes = pacienteDAO.filtrar(cpf);
			Paciente paciente = new Paciente ();
			if (pacientes.size() > 0) {
				for (Paciente pacienteFor : pacientes) {
					paciente.setNome(pacienteFor.getNome());;
					paciente.setEndereco(pacienteFor.getEndereco());
					paciente.setCpf(pacienteFor.getCpf());
					paciente.setEmail(pacienteFor.getEmail());
					paciente.setTelefone(pacienteFor.getTelefone());
					paciente.setTipoSanguineo(pacienteFor.getTipoSanguineo());
					paciente.setAlergia(pacienteFor.getAlergia());
					paciente.setObservacao(pacienteFor.getObservacao());
					paciente.setDataNascimento(pacienteFor.getDataNascimento());
					
					if (pacienteFor.getResponsavel() != null) {
						if (pacienteFor.getResponsavel().getNome() != null && pacienteFor.getResponsavel().getCpf() != null) {
							Responsavel responsavel = new Responsavel();
							responsavel.setNome(pacienteFor.getResponsavel().getNome());
							responsavel.setCpf(pacienteFor.getResponsavel().getCpf());
							paciente.setResponsavel(responsavel);
						}
					}
					return paciente;
				} 
			}
		}
		return null;
	}
	
	
	
	public boolean filtrarPaciente(JTextField cpf, JTextField nome) throws SQLException {
		if (cpf != null) {
			if (cpf.getText().isBlank() || cpf.getText().equals("") || !(TextFieldService.validarNumero(cpf.getText()))) {
				return false;
			} else {
				PacienteDAO pacienteDAO = new PacienteDAO();
				Paciente paciente = pacienteDAO.filtrarPaciente(cpf.getText());
				if (paciente != null) {
					if (paciente.getNome() != null) {
						nome.setText(paciente.getNome());
						cpf.setText(cpf.getText());
					}
				}
			}
		}
		return false;
	}
	
	public boolean cadastrar(String nome, String telefone, String email, String cpf,
			String tipoSanguineo, String alergia, String dataNascimento, String endereco, String observacao, Responsavel responsavel) throws SQLException {
		
		Paciente paciente = new Paciente(nome, telefone, email, cpf, tipoSanguineo, alergia,dataNascimento, endereco, observacao);
		PacienteDAO pacienteDao = new PacienteDAO();
		
		if (!(TextFieldService.validarEmail(email)) || !(endereco.length() <= 100) || !(alergia.length() <= 100) || !(observacao.length() <= 500) || !(tipoSanguineo.length() <= 3) || nome.isBlank() || cpf.isBlank() || telefone.isBlank() || !(TextFieldService.validarData(dataNascimento))) {
			return false;
		} else {
			if(verificarDadosObrigatorios(paciente)) {
				pacienteDao.adicionar(paciente, responsavel);
				return true;
			}
			return false;
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
	
	public boolean deletarPaciente(String cpf) throws SQLException {
		if (cpf.isBlank()) {
			return false;
		} else {
		PacienteDAO pacienteDAO = new PacienteDAO();
		pacienteDAO.excluir(cpf);
		return true;
		}
	}
	
	public boolean alterar(String cpf, String nome, String email, String telefone, String alergia, String tipoSanguineo, String dataNascimento, String endereco, String cpfResponsavel, String nomeResponsavel, String TelefoneResponsavel, String observacao) throws SQLException {
		if (!(TextFieldService.validarNumero(cpf)) || !(TextFieldService.validarNumero(telefone)) || !(TextFieldService.validarEmail(email)) || !(TextFieldService.validarData(dataNascimento)) || nome.isBlank() || (endereco.length() > 100) || (nomeResponsavel.length() > 100) || (TelefoneResponsavel.length() > 13) || (nome.length() > 100) ||  (observacao.length() > 500) ||(alergia.length() > 100) ||(tipoSanguineo.length() > 20)) {
			return false;
		} else {
			Paciente paciente = new Paciente ();
			paciente.setCpf(cpf);
			paciente.setNome(nome);
			paciente.setEmail(email);
			paciente.setDataNascimento(dataNascimento);
			paciente.setTelefone(telefone);
			paciente.setEndereco(endereco);
			paciente.setTipoSanguineo(tipoSanguineo);
			paciente.setAlergia(alergia);
			paciente.setObservacao(observacao);
			

			Responsavel responsavel = new Responsavel("", "", "", "");
			if (cpfResponsavel != null && !(cpfResponsavel.equals(""))) {
				if(TextFieldService.validarNumero(cpfResponsavel) && TextFieldService.validarNumero(TelefoneResponsavel) && (nomeResponsavel.length() < 100)){
				responsavel.setCpf(cpfResponsavel);
				responsavel.setTelefone(TelefoneResponsavel);
				responsavel.setNome(nomeResponsavel);
				
				ResponsavelDAO responsavelDAO = new ResponsavelDAO();
				responsavelDAO.alterar(responsavel);
				paciente.setResponsavel(responsavel);
				} else {
					return false;
				}
			}
			PacienteDAO pacienteDAO = new PacienteDAO();
			pacienteDAO.alterar(paciente, responsavel);
			return true;
		}
	}
	
}

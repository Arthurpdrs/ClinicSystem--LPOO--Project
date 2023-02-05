package core.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import core.model.Medico;
import core.model.Paciente;
import core.model.Recepcionista;
import dao.MedicoDAO;
import dao.PacienteDAO;
import dao.RecepcionistaDAO;

public class MedicoService {
	
	public boolean filtrar(JComboBox jcombobox, String especialidade) throws SQLException {
		if (especialidade.isBlank() || jcombobox == null) {
			return false;
		} else {
			List<String> string = new ArrayList<String>();
			
			MedicoDAO medicoDAO = new MedicoDAO();
			List<Medico> medicos = medicoDAO.filtrarEspecialidade(especialidade);
			if (medicos.size() > 0) {
				for (Medico medico : medicos) {
						string.add( "(" + medico.getCpf() + ") " + medico.getNome());
					}
			} 
			
			DefaultComboBoxModel model = new DefaultComboBoxModel(string.toArray());
			jcombobox.setModel(model);
			return true;
		}
}
	
	
	public boolean cadastrar(String nome, String telefone, String email, String cpf, String login, String senha, String crm, String especialidade) throws SQLException {
		
		Medico medico = new Medico(nome, telefone, email, cpf, login, senha, crm, especialidade);
		
		if(verificarDadosObrigatorios(medico) && TextFieldService.validarEmail(email) && TextFieldService.validarNumero(telefone) && TextFieldService.validarNumero(cpf) && TextFieldService.validarCRM(crm) && (especialidade.length() < 45)) {
			MedicoDAO medicoDAO = new MedicoDAO();
			medicoDAO.inserir(medico);
			return true;
		}
		
		return false;
	}
	
	private boolean verificarDadosObrigatorios(Medico medico) {
		
		List<String> dadosObrigatorios = new ArrayList<String>();
		dadosObrigatorios.add(medico.getNome());
		dadosObrigatorios.add(medico.getTelefone());
		dadosObrigatorios.add(medico.getEmail());
		dadosObrigatorios.add(medico.getCpf());
		dadosObrigatorios.add(medico.getLogin());
		dadosObrigatorios.add(medico.getSenha());
		dadosObrigatorios.add(medico.getCrm());
		dadosObrigatorios.add(medico.getEspecialidade());
		
		for(String dado : dadosObrigatorios) {
		
			if(dado.isBlank()) {
				return false;
			}
		}
		
		return true;
	}

	public boolean alterar(String cpf, String nome, String telefone, String login, String email, String senha, String crm, String especialidade) throws SQLException {
		if (!(TextFieldService.validarNumero(cpf)) || !(TextFieldService.validarCRM(crm)) || !(TextFieldService.validarNumero(telefone)) || !(TextFieldService.validarEmail(email)) || nome.isBlank() || login.isBlank() || senha.isBlank() || (nome.length() > 100) || (login.length() > 20) || (senha.length() > 15) || (especialidade.length() > 45)) {
			return false;
		} else {
			Medico medico = new Medico ();
			medico.setCpf(cpf);
			medico.setNome(nome);
			medico.setEmail(email);
			medico.setTelefone(telefone);
			medico.setLogin(login);
			medico.setSenha(senha);
			medico.setEspecialidade(especialidade);
			medico.setCrm(crm);
			MedicoDAO medicoDAO = new MedicoDAO();
			medicoDAO.alterar(medico);
			return true;
		}
	}
	
	public boolean excluir (String cpf) throws SQLException {
		if (!(TextFieldService.validarNumero(cpf))) {
			return false;
		} else {
			Medico medico = new Medico();
			MedicoDAO medicoDAO = new MedicoDAO();
			medico.setCpf(cpf);
			medicoDAO.excluir(medico);
			return true;
		}
	}
}

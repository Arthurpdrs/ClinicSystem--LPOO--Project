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
import dao.MedicoDAO;
import dao.PacienteDAO;

public class MedicoService extends FuncionarioService{
	
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
	
	
	public void cadastrar(String nome, String telefone, String email, String cpf, String login, String senha, String crm, String especialidade) throws SQLException {
		
		Medico medico = new Medico(nome, telefone, email, cpf, login, senha, crm, especialidade);
		
		if(verificarDadosObrigatorios(medico)) {
			
			MedicoDAO medicoDAO = new MedicoDAO();
			medicoDAO.inserir(medico);
		}
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

}

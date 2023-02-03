package core.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.model.Medico;
import core.model.Paciente;
import dao.MedicoDAO;

public class MedicoService extends FuncionarioService{
	
	
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

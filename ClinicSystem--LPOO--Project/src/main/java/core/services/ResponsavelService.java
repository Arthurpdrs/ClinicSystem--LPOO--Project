package core.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.model.Paciente;
import core.model.Responsavel;
import dao.ResponsavelDAO;

public class ResponsavelService {
	
	public Responsavel inserir(String nome, String cpf, String telefone) throws SQLException {
		
		Responsavel responsavel = new Responsavel(nome, cpf, telefone);
		ResponsavelDAO responsavelDao = new ResponsavelDAO();
		
		if(verificarDadosObrigatorios(responsavel)) {
			responsavelDao.inserir(responsavel);
		}
		return responsavel;
		
	}
	
	private boolean verificarDadosObrigatorios(Responsavel responsavel) {
		
			List<String> dadosObrigatorios = new ArrayList<String>();
			dadosObrigatorios.add(responsavel.getNome());
			dadosObrigatorios.add(responsavel.getTelefone());
			dadosObrigatorios.add(responsavel.getCpf());
			
			for(String dado : dadosObrigatorios) {
			
				if(dado.isBlank()) {
					return false;
				}
			
			}
				return true;
		}
}

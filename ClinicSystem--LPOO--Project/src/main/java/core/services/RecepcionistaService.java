package core.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.model.Recepcionista;
import dao.RecepcionistaDAO;

public class RecepcionistaService {
	
public void cadastrar(String nome, String telefone, String email, String cpf, String login, String senha) throws SQLException {
		
		Recepcionista recepcionista = new Recepcionista(nome, telefone, email, cpf, login, senha);
		
		if(verificarDadosObrigatorios(recepcionista)) {
			
			RecepcionistaDAO recepcionistaDAO = new RecepcionistaDAO();
			recepcionistaDAO.inserir(recepcionista);
		}
	}
	
	private boolean verificarDadosObrigatorios(Recepcionista recepcionista) {
		
		List<String> dadosObrigatorios = new ArrayList<String>();
		dadosObrigatorios.add(recepcionista.getNome());
		dadosObrigatorios.add(recepcionista.getTelefone());
		dadosObrigatorios.add(recepcionista.getEmail());
		dadosObrigatorios.add(recepcionista.getCpf());
		dadosObrigatorios.add(recepcionista.getLogin());
		dadosObrigatorios.add(recepcionista.getSenha());

		
		for(String dado : dadosObrigatorios) {
		
			if(dado.isBlank()) {
				return false;
			}
		}
		
		return true;
	}

}

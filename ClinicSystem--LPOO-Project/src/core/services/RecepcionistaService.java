package core.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.model.Paciente;
import core.model.Recepcionista;
import core.model.Responsavel;
import dao.PacienteDAO;
import dao.RecepcionistaDAO;
import dao.ResponsavelDAO;

public class RecepcionistaService {
	
public boolean cadastrar(String nome, String telefone, String email, String cpf, String login, String senha) throws SQLException {
		
		Recepcionista recepcionista = new Recepcionista(nome, telefone, email, cpf, login, senha);
		
		if(verificarDadosObrigatorios(recepcionista) && TextFieldService.validarEmail(email) && TextFieldService.validarNumero(telefone) && TextFieldService.validarNumero(cpf)) {
			RecepcionistaDAO recepcionistaDAO = new RecepcionistaDAO();
			recepcionistaDAO.inserir(recepcionista);
			return true;
		}
		return false;
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
	
	public boolean alterar(String cpf, String nome, String telefone, String login, String email, String senha) throws SQLException {
		if (!(TextFieldService.validarNumero(cpf)) || !(TextFieldService.validarNumero(telefone)) || !(TextFieldService.validarEmail(email)) || nome.isBlank() || login.isBlank() || senha.isBlank() || (nome.length() > 100) || (login.length() > 20) || (senha.length() > 15)) {
			return false;
		} else {
			Recepcionista recepcionista = new Recepcionista ();
			recepcionista.setCpf(cpf);
			recepcionista.setNome(nome);
			recepcionista.setEmail(email);
			recepcionista.setTelefone(telefone);
			recepcionista.setLogin(login);
			recepcionista.setSenha(senha);
			RecepcionistaDAO recepcionistaDAO = new RecepcionistaDAO();
			recepcionistaDAO.alterar(recepcionista);
			return true;
		}
	}
	
	public boolean excluir (String cpf) throws SQLException {
		if (!(TextFieldService.validarNumero(cpf))) {
			return false;
		} else {
			Recepcionista recepcionista = new Recepcionista();
			RecepcionistaDAO recepcionistaDAO = new RecepcionistaDAO();
			recepcionista.setCpf(cpf);
			recepcionistaDAO.excluir(recepcionista);
			return true;
		}
	}
}

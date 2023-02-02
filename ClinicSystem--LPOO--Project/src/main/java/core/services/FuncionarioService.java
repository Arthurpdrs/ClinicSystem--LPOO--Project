package core.services;

import java.sql.SQLException;
import core.model.Funcionario;
import dao.FuncionarioDAO;

public class FuncionarioService {
	
	public boolean fazerLogin(String login, String senha) throws SQLException {
		if (login.isBlank() || senha.isBlank()) {
			return false;
		} else {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			Funcionario funcionario = funcionarioDAO.verificarLogin(login);
			if (funcionario.getSenha() == null) {
				return false;
			} else {
				if (login.equals(funcionario.getLogin()) && senha.equals(funcionario.getSenha())) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

}

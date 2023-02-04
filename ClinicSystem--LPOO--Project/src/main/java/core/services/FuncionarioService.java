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
			Funcionario funcionario = funcionarioDAO.verificar(login);
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
	
	public boolean inserirLogin(String usuario, String senha, String cargo, String cpf) throws SQLException {
		if (usuario.isBlank() || senha.isBlank() || cargo.isBlank() || cpf.isBlank()) {
			return false;
		} else {
			String usuarioLower = usuario.toLowerCase().trim();
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.inserir(usuarioLower, cargo, senha, cpf);
			return true;
		}
	}
	
	public boolean deletarLogin(String cpf) throws SQLException {
		if (cpf.isBlank()) {
			return false;
		} else {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.deletar(cpf);
			return true;
		}
	}
}

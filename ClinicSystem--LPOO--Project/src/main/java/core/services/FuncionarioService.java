package core.services;

import java.sql.SQLException;

import core.model.Funcionario;
import dao.FuncionarioDAO;

public class FuncionarioService {
	
	private boolean logado = false;
	
	public void fazerLogin(String login, String senha) {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setLogin(login);
		funcionario.setSenha(senha);
		
		if(logado == false) {
			FuncionarioDAO funcionarioDao = new FuncionarioDAO();
			try {
				funcionarioDao.verificarLogin(funcionario);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//completar...
		}
	}

}

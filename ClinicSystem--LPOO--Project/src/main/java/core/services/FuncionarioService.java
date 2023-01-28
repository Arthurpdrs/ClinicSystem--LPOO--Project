package core.services;

import java.sql.SQLException;

import dao.FuncionarioDAO;

public class FuncionarioService {
	
	private boolean logado = false;
	
	public void fazerLogin(String usuario, String senha) {
		
		if(logado == false) {
			FuncionarioDAO funcionarioDao = new FuncionarioDAO();
			try {
				funcionarioDao.verificarLogin(usuario, senha);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//completar...
		}
	}

}

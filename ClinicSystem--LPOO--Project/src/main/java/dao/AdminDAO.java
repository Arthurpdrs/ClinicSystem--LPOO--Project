package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDAO extends FabricaConexao {
	
	FabricaConexao admin = new FabricaConexao();
	
	public boolean verificarLoginAdmin(String senha, String login) throws SQLException{
		try {
			PreparedStatement select = admin.getConexao().prepareStatement("SELECT Login, Senha FROM Administrador u WHERE u.Login = ? AND u.Senha = ?");
			select.setString(1, login);
			select.setNString(2, senha);
			return select.execute();
		} finally {
			admin.fecharConexao();
		}
	
			
	}
	
	
	public boolean addFunionario(String Login, String Senha, String Pessoa_CPF) throws SQLException {
		try {
			PreparedStatement insert = admin.getConexao().prepareStatement("INSERT INTO Funcionario(Login, Senha) VALUES(?, ?)");
			insert.setString(1, Login);
			insert.setString(2, Senha);
			insert.setString(3, Pessoa_CPF);
			return insert.execute();	
		} finally {
			admin.fecharConexao();
		}
		
	}
	
	
	public boolean deletarFuncionario(String Pessoa_CPF) throws SQLException{
		try {
			PreparedStatement insert = admin.getConexao().prepareStatement("DELETE FROM Funcionario WHERE Pessoa_CPF = ?");
			insert.setString(1, Pessoa_CPF);
			return insert.execute();	
		} finally {
			admin.fecharConexao();
		}
		
	}

}



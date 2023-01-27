package dao;

import java.sql.PreparedStatement;

import java.sql.SQLException;

public class FuncionarioDAO extends FabricaConexao{
	
	FabricaConexao funcionario = new FabricaConexao();
	
	
	public boolean verificarLogin(String login, String senha) throws SQLException{
		
		
		try {
			PreparedStatement select = funcionario.getConexao().prepareStatement("SELECT Login, Senha FROM 	Funcionario u WHERE u.Login = ? AND u.Senha = ?");
			select.setString(1, login);
			select.setNString(2, senha);
			return select.execute();
		} finally {
			funcionario.fecharConexao();
		}
	
			
	}
	
	public boolean addFunionario(String Login, String Senha, String Pessoa_CPF) throws SQLException {
		try {
			PreparedStatement insert = funcionario.getConexao().prepareStatement("INSERT INTO Funcionario(Login, Senha) VALUES(?, ?)");
			insert.setString(1, Login);
			insert.setString(2, Senha);
			insert.setString(3, Pessoa_CPF);
			return insert.execute();	
		} finally {
			funcionario.fecharConexao();
		}
		
	}
	
	
	public boolean deletarFuncionario(String Pessoa_CPF) throws SQLException{
		try {
			PreparedStatement insert = funcionario.getConexao().prepareStatement("DELETE FROM Funcionario WHERE Pessoa_CPF = ?");
			insert.setString(1, Pessoa_CPF);
			return insert.execute();	
		} finally {
			funcionario.fecharConexao();
		}
		
	}


	
	
	public static void main(String [] args ) throws SQLException {
		FuncionarioDAO teste = new FuncionarioDAO();
		teste.verificarLogin("", "");

		
	}


}

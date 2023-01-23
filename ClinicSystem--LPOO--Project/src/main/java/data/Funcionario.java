package data;

import java.sql.PreparedStatement;

import java.sql.SQLException;

public class Funcionario extends FabricaConexao{
	
	FabricaConexao funcionario = new FabricaConexao();
	
	
	public boolean verificarLogin(String login, String senha) throws SQLException{
		
		
		try {
			PreparedStatement select = funcionario.getConexao().prepareStatement("SELECT Login, Senha FROM 	Funcionario u WHERE u.Login = ? AND u.senha = ?");
			select.setString(1, login);
			select.setNString(2, senha);
			return select.execute();
		} finally {
			funcionario.fecharConexao();
		}
	
			
	}
	
	
	public boolean addCPF(String cpf) throws SQLException {
		try {
			PreparedStatement insert = funcionario.getConexao().prepareStatement("INSERT INTO Funcionario(Pessoa_CPF) VALUES(?)");
			insert.setString(1, cpf);
			return insert.execute();	
		} finally {
			funcionario.fecharConexao();
		}
		
		
	}
	
	public static void main(String [] args ) throws SQLException {
		Funcionario teste = new Funcionario();
		teste.addCPF("71590934289");

		
	}


}

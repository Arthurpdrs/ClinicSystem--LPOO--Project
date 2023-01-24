package data;

import java.sql.PreparedStatement;

import java.sql.SQLException;

public class Funcionario extends FabricaConexao{
	
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

	
	
	public static void main(String [] args ) throws SQLException {
		Funcionario teste = new Funcionario();
		teste.verificarLogin("", "");

		
	}


}

package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;

public class FabricaConexao {
	
	private static final String usuario = "admin";
	private static final String senha = "12345678";
	private static final String url = "jdbc:mysql:aws://database-2.ckzqkucrjrxv.us-east-1.rds.amazonaws.com:3306/BancoLPOO";


	
	public void getConexao(String stringSQL){
		
	
		try {	
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			PreparedStatement requisição = conexao.prepareStatement(stringSQL);
			requisição.execute(stringSQL);
			conexao.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}




		
	
	
	
}
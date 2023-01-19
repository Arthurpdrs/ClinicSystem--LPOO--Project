package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FabricaConexao {
	
	private static final String usuario = "admin";
	private static final String senha = "12345678";
	private static final String url = "jdbc:mysql:aws://database-2.ckzqkucrjrxv.us-east-1.rds.amazonaws.com:3306/BancoLPOO"; 

	
	public String getConnectoin(String stringSQL){
	
		try {
	
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			Statement requisição = conexao.createStatement();
			requisição.executeUpdate(stringSQL);

			return "banco conectado";
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	
	
	public static void main(String [] args ) {
		FabricaConexao testeconexao = new FabricaConexao();
		testeconexao.getConnectoin("insert into README(id) values ('66666')");
		

	}
		
	
		
	
}
package data;



import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Conexao {

	private static final String usuario = "admin";
	private static final String senha = "12345678";
	private static final String url = "database-2.ckzqkucrjrxv.us-east-1.rds.amazonaws.com"; 
	
	
	public static Connection getConexao() throws SQLException {
		
		return DriverManager.getConnection(url, usuario, senha);
	}
	
	

}



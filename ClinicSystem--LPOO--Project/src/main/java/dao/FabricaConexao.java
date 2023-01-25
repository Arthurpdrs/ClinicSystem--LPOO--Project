package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class FabricaConexao {
	
	private static final String usuario = "admin";
	private static final String senha = "12345678";
	private static final String url = "jdbc:mysql:aws://database-2.ckzqkucrjrxv.us-east-1.rds.amazonaws.com:3306/BancoLPOO";

	Connection conexao = null;
	
	public Connection getConexao() throws SQLException{
		
		return conexao = DriverManager.getConnection(url, usuario, senha);
	
	}
	
	public void fecharConexao() throws SQLException {
		conexao.close();
		}
	
	
}
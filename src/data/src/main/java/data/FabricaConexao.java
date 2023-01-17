package data;



import java.sql.PreparedStatement;


public class FabricaConexao {
	
	private Conexao conexao =null;
	
	public Conexao gerarConexao() {
		if(conexao == null) {
			this.conexao = new Conexao();
			System.out.println("conexao bem sucedida");
		}
		
		return this.conexao;
	}
	
	
		

	
	
	
	public PreparedStatement prepareStatement(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
		
	
		
	
}
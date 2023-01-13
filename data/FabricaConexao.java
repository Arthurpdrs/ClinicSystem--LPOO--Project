package data;


public class FabricaConexao {
	
	private Conexao conexao =null;
	
	public Conexao gerarConexao() {
		if(conexao == null) {
			this.conexao = new Conexao();
			System.out.println("conexao bem sucedida");
		}
		
		return this.conexao;
	}
	
	public static void main(String[] args) {
		FabricaConexao testeconexao = new FabricaConexao();
		testeconexao.gerarConexao();
		
	}
}
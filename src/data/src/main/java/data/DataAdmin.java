package data;



public class DataAdmin{

	
		
	public void inserir() {
		FabricaConexao testeconexao = new FabricaConexao();
		testeconexao.gerarConexao();
		testeconexao.prepareStatement("INSERT INTO Pessoa(Nome) VALUES ('DIANA')");
	
	}
	
	public static void main(String[] args) {
		DataAdmin testeadmin = new DataAdmin();
		testeadmin.inserir();	
	}
	

}

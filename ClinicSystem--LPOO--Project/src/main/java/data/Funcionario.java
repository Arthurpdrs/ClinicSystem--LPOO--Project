package data;

public class Funcionario extends FabricaConexao{
	
	FabricaConexao funcionario = new FabricaConexao();
	
	
	public void verificarLogin(String senha, String login){
		String senhaFuncionario = senha;
		String loginFuncionario = login;
		String select = "INSERT INTO "+ senhaFuncionario + "(id) "+ "VALUES('"+ loginFuncionario+"')";
		funcionario.getConexao(select);
		System.out.print("PEGPU ");
	
			
	}
	
	
	public static void main(String [] args ) {
		Funcionario testeconlogin = new Funcionario();
		testeconlogin.verificarLogin("README", "49");

		
		
	}

	
	

}

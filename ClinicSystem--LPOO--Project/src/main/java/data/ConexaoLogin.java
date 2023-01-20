package data;

public class ConexaoLogin extends FabricaConexao{
	
	FabricaConexao conexaoLogin = new FabricaConexao();
	
	
	public void verificarLogin(String senha, String login){
		String senhaFuncionario = senha;
		String loginFuncionario = login;
		String select = "INSERT INTO "+ senhaFuncionario + "(id) "+ "VALUES('"+ loginFuncionario+"')";
		conexaoLogin.getConexao(select);
		System.out.print("PEGPU ");
	
			
	}
	
	
	public static void main(String [] args ) {
		ConexaoLogin testeconlogin = new ConexaoLogin();
		testeconlogin.verificarLogin("README", "49");

		
		
	}

	
	

}

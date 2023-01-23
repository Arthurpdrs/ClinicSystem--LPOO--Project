package data;

public class AdminConexao extends FabricaConexao {
	
	FabricaConexao admin = new FabricaConexao();
	
	public void verificarLogin(String senha, String login){
		String senhaAdmin = senha;
		String loginAdmin = login;
		String select = "SELECT "+ senhaAdmin + ", "+ loginAdmin +"FROM README";
		admin.getConexao(select);
		System.out.print("Pegou ");
	
			
	}
	
	
	public String inserirFuncionario(String senha, String login ) {
		String senhaFuncionario = senha;
		String loginFuncionario = login;
		String insertFuncionario = "INSERT INTO "+ senhaFuncionario + "(id) "+ "VALUES('"+ loginFuncionario+"')";
		admin.getConexao(insertFuncionario);
		
		return null;
		}
	
	
	public String deletarFuncionario(String CPF) {
		String cpfFuncionario = CPF;
		String insert = "DELETE FROM Funcionario WHERE Pessoa_CPF = "+ cpfFuncionario;  
		admin.getConexao(insert);
		
		return null;}

}



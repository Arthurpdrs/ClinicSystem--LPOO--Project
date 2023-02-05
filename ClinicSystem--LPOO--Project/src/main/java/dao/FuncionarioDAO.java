package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import core.model.Funcionario;

public class FuncionarioDAO {
	
	
	FabricaConexao funcionarioDAO = new FabricaConexao();
	
	public Funcionario verificar(String login) throws SQLException {
		String senha;
		
		Funcionario funcionario = new Funcionario();
		funcionario.setLogin(login);
		
		String sqlSelectLogin = "SELECT * FROM Login WHERE Usuario = ?";
		
		PreparedStatement selectLogin = funcionarioDAO.getConexao().prepareStatement(sqlSelectLogin);
		selectLogin.setString(1, login);
		
		ResultSet resultadoLogin = selectLogin.executeQuery();
		
		if(resultadoLogin.next() == true) {
			if (!(resultadoLogin.getString("Senha").equals(null) || resultadoLogin.getString("Usuario").equals(null) || resultadoLogin.getString("Cargo").equals(null))) {
				senha = resultadoLogin.getString("Senha");
				funcionario.setSenha(senha); 
				
				String cargo = resultadoLogin.getString("Cargo");
				String cpf = resultadoLogin.getString("Cpf");
				
				if (cargo.equals("MEDICO")) {
					System.setProperty("cargo", "Medico");
				} else if (cargo.equals("RECEPCIONISTA")) {
					System.setProperty("cargo", "Recepcionista");
				} else {
					System.setProperty("cargo", "Administrador");
				}
				System.setProperty("cpf_logado", cpf);
				
			} else {
				funcionario.setSenha(null);
			}
		} else {
			funcionario.setSenha(null);
		}
		
		funcionarioDAO.fecharConexao();
		return funcionario;
	}		
	
	public boolean inserir(String usuario, String cargo, String senha, String cpf) throws SQLException {
			String sqlInsertLogin = "INSERT INTO Login (Usuario, Cargo, Senha, CPF) VALUES (?, ?, ?, ?)";
			PreparedStatement insertLogin = funcionarioDAO.getConexao().prepareStatement(sqlInsertLogin);
			insertLogin.setString(1, usuario);
			insertLogin.setString(2, cargo);
			insertLogin.setString(3, senha);
			insertLogin.setString(4, cpf);
			insertLogin.execute();
			funcionarioDAO.fecharConexao();
			return true;
	}
	
	public boolean deletar(String cpf) throws SQLException {
		String sqlDeletarLogin = "DELETE FROM Login WHERE CPF = ?";
		PreparedStatement deleteLogin = funcionarioDAO.getConexao().prepareStatement(sqlDeletarLogin);
		deleteLogin.setString(1, cpf);
		deleteLogin.execute();
		funcionarioDAO.fecharConexao();
		return true;
	}
	
	public String totalFuncionarios() throws SQLException {
		String sql = "SELECT COUNT(*) as Total FROM Login where Cargo = 'MEDICO' or Cargo = 'RECEPCIONISTA'";
		PreparedStatement count = funcionarioDAO.getConexao().prepareStatement(sql);
		ResultSet resultado = count.executeQuery();
		String retorno = "";
		if(resultado.next()){
			retorno = resultado.getString("Total");
		}
		funcionarioDAO.fecharConexao();
		return retorno;
	}

}

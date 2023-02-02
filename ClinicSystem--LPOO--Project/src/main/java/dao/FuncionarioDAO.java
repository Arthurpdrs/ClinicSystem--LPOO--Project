package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import core.model.Funcionario;

public class FuncionarioDAO {
	
	
	FabricaConexao funcionarioDAO = new FabricaConexao();
	
	public Funcionario verificarLogin(String login) throws SQLException {
		String senha;
		
		Funcionario funcionario = new Funcionario();
		funcionario.setLogin(login);
		
		String sqlSelectRecepcionista = "SELECT * FROM Recepcionista WHERE Login = ?";
		
		PreparedStatement selectRecepcionista = funcionarioDAO.getConexao().prepareStatement(sqlSelectRecepcionista);
		selectRecepcionista.setString(1, login);
		
		ResultSet resultadoRecepcionista = selectRecepcionista.executeQuery();
		
		if(resultadoRecepcionista.next() == true) {
			senha = resultadoRecepcionista.getString("Senha");
			funcionario.setSenha(senha); 
			System.setProperty("cargo", "Recepcionista");
		} else {
			String sqlSelectMedico = "SELECT * FROM Recepcionista WHERE Login = ?";
			PreparedStatement selectMedico = funcionarioDAO.getConexao().prepareStatement(sqlSelectMedico);
			selectMedico.setString(1, login);
			
			ResultSet resultadoMedico = selectMedico.executeQuery();
			
			if(resultadoMedico.next() == true) {
				senha = resultadoMedico.getString("Senha");
				funcionario.setSenha(senha);
				System.setProperty("cargo", "Medico");
				} else {
					String sqlSelectAdmin = "SELECT * FROM Administrador WHERE Login = ?";
					PreparedStatement selectAdmin = funcionarioDAO.getConexao().prepareStatement(sqlSelectAdmin);
					selectAdmin.setString(1, login);
					
					ResultSet resultadoAdmin = selectAdmin.executeQuery();
					if(resultadoAdmin.next() == true) {
						senha = resultadoAdmin.getString("Senha");
						System.setProperty("cargo", "Administrador");
						funcionario.setSenha(senha); 
					} else {
						funcionario.setSenha(null);
					}
			}
		}
		
		funcionarioDAO.fecharConexao();
		return funcionario;
	}		
	
}

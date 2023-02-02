package dao;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import core.model.Funcionario;

public class FuncionarioDAO {
	
	
	FabricaConexao conexao = new FabricaConexao();
	
	
	public void verificarLogin(Funcionario funcionario ) throws SQLException{
		
		
		try {
			PreparedStatement select = conexao.getConexao().prepareStatement("SELECT Login, Senha FROM 	Funcionario u WHERE u.Login = ? AND u.Senha = ?");
			select.setString(1, funcionario.getLogin());
			select.setNString(2, funcionario.getSenha());
			select.execute();
		} catch (SQLException e) {
			System.out.println("Não foi possível verificar!");
		}
		 finally {
			conexao.fecharConexao();
		}
	}
			
	
	
	public void addFunionario(Funcionario funcionario ) throws SQLException {
		try {
			PreparedStatement insert = conexao.getConexao().prepareStatement("INSERT INTO Funcionario(Login, Senha) VALUES(?, ?)");
			insert.setString(1, funcionario.getLogin());
			insert.setString(2, funcionario.getLogin());
			insert.execute();
		} catch (SQLException e) {
			System.out.println("Não foi possível Adcionar os dados da Funcionario!");
		}
		 finally {
			conexao.fecharConexao();
		}
		
	}
	
	
	public void deletarFuncionario(Funcionario funcionario) throws SQLException{
		try {
			PreparedStatement insert = conexao.getConexao().prepareStatement("DELETE FROM Funcionario WHERE Pessoa_CPF = ?");
			insert.setString(1, funcionario.getCpf());
			insert.execute();
		} catch (SQLException e) {
			System.out.println("Não foi possível Deletar os dados do Funcionario!");
		}
		finally {
			conexao.fecharConexao();
		}
		
	}
	
	public boolean atualizarDados() {
		}
	



	
	
	public static void main(String [] args ) throws SQLException {
		FuncionarioDAO teste = new FuncionarioDAO();
		

		
	}


}

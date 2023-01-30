package dao;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import core.model.Funcionario;

public class FuncionarioDAO extends PessoaDAO{
	
	PessoaDAO funcionarioDao = new PessoaDAO();
	
	
	public boolean verificarLogin(Funcionario funcionario ) throws SQLException{
		
		
		try {
			PreparedStatement select = funcionarioDao.getConexao().prepareStatement("SELECT Login, Senha FROM 	Funcionario u WHERE u.Login = ? AND u.Senha = ?");
			select.setString(1, funcionario.getLogin());
			select.setNString(2, funcionario.getSenha());
			return select.execute();
		} catch (SQLException e) {
			System.out.println("Não foi possível verificar!");
		}
		 finally {
			funcionarioDao.fecharConexao();
		}
	
			
	
	
	public boolean addFunionario(Funcionario funcionario ) throws SQLException {
		try {
			PreparedStatement insert = funcionarioDao.getConexao().prepareStatement("INSERT INTO Funcionario(Login, Senha) VALUES(?, ?)");
			insert.setString(1, funcionario.getLogin());
			insert.setString(2, funcionario.getLogin());
			insert.setString(3, funcionario.getLogin());
			return insert.execute();
		} catch (SQLException e) {
			System.out.println("Não foi possível Adcionar os dados da Funcionario!");
		}
		 finally {
			funcionarioDao.fecharConexao();
		}
		
	
	
	public boolean deletarFuncionario(Funcionario funcionario) throws SQLException{
		try {
			PreparedStatement insert = funcionarioDao.getConexao().prepareStatement("DELETE FROM Funcionario WHERE Pessoa_CPF = ?");
			insert.setString(1, funcionario.getCpf());
			return insert.execute();
		} catch (SQLException e) {
			System.out.println("Não foi possível Deletar os dados do Funcionario!");
		}
		finally {
			funcionarioDao.fecharConexao();
		}
		
	}
	
	public boolean atualizarDados() {
		}
	}


	
	
	public static void main(String [] args ) throws SQLException {
		FuncionarioDAO teste = new FuncionarioDAO();
		

		
	}


}

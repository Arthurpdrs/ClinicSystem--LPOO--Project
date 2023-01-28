package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pessoa;

public class PessoaDAO extends FabricaConexao{
	
	FabricaConexao pessoaDAO = new FabricaConexao();
	public String CPF = null;
	
	public List<Pessoa> listar() {
		String sql = "SELECT * FROM Pessoa";
		List<Pessoa> retorno = new ArrayList();
		try {
			PreparedStatement stmt = pessoaDAO.getConexao().prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setCpf(resultado.getString("CPF"));
				pessoa.setNome(resultado.getString("Nome"));
				pessoa.setTelefone(resultado.getString("Telefone"));
				pessoa.setEmail(resultado.getString("Email"));
				retorno.add(pessoa);
			}
		} catch (SQLException e) {
			System.out.println("Não foi possível listar os dados da pessoa!");
		}
		return retorno;
	}
	
	public boolean inserir(String cpf, String nome, String telefone, String email) throws SQLException {
		String sql = "INSERT INTO Pessoa(CPF, Nome, Telefone, Email) VALUES(?, ?, ?, ?)";
		CPF = cpf;
		try {
			PreparedStatement stmt = pessoaDAO.getConexao().prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.setString(2, nome);
			stmt.setString(3, telefone);
			stmt.setString(4, email);
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Não foi possível inserir os dados da pessoa!");
			return false;	
		} finally {
			pessoaDAO.fecharConexao();
			
		}
	
	}
	
	public boolean alterar(Pessoa pessoa) {
		String sql = "UPDATE Pessoa SET CPF=?, Nome=?, Telefone=?, Email=? WHERE CPF=?";
		
		try {
			PreparedStatement stmt = pessoaDAO.getConexao().prepareStatement(sql);
			stmt.setString(1, pessoa.getCpf());
			stmt.setString(2, pessoa.getNome());
			stmt.setString(3, pessoa.getTelefone());
			stmt.setString(4, pessoa.getEmail());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Não foi possível alterar os dados da pessoa!");
			return false;
		} finally {
			pessoaDAO.fecharConexao();
			
		}
		
	}
	
	public boolean remover(String cpf) throws SQLException {
		String sql = "DELETE FROM Pessoa WHERE CPF=?";
		try {
			PreparedStatement stmt = pessoaDAO.getConexao().prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Não foi possível deletar os dados da pessoa!");
			return false;
		}finally {
			pessoaDAO.fecharConexao();
			
		}
		
	}
}

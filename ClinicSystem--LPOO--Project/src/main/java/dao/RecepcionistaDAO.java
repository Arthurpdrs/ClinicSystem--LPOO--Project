package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import core.model.Recepcionista;

public class RecepcionistaDAO {
	
FabricaConexao recepcionistaDAO = new FabricaConexao();
	
    public List<Recepcionista> listar() throws SQLException {
    	String sql = "SELECT * FROM Recepcionista";
		List<Recepcionista> retorno = new ArrayList();
		PreparedStatement stmt = recepcionistaDAO.getConexao().prepareStatement(sql);
		ResultSet resultado = stmt.executeQuery();
		while(resultado.next()) {
			Recepcionista recepcionista = new Recepcionista();
			recepcionista.setCpf(resultado.getString("CPF"));
			recepcionista.setNome(resultado.getString("Nome"));
			recepcionista.setTelefone(resultado.getString("Telefone"));
			recepcionista.setEmail(resultado.getString("Email"));
			recepcionista.setLogin(resultado.getString("Login"));
			recepcionista.setSenha(resultado.getString("Senha"));
			retorno.add(recepcionista);
		}
		recepcionistaDAO.fecharConexao();
		return retorno;
	}
    
    public List<Recepcionista> filtrar(String cpf) throws SQLException {
    	String sql = "SELECT * FROM Recepcionista WHERE CPF = ?";
		List<Recepcionista> retorno = new ArrayList();
		PreparedStatement stmt = recepcionistaDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, cpf);
		ResultSet resultado = stmt.executeQuery();
		while(resultado.next()) {
			Recepcionista recepcionista = new Recepcionista();
			recepcionista.setCpf(resultado.getString("CPF"));
			recepcionista.setNome(resultado.getString("Nome"));
			recepcionista.setTelefone(resultado.getString("Telefone"));
			recepcionista.setEmail(resultado.getString("Email"));
			recepcionista.setLogin(resultado.getString("Login"));
			recepcionista.setSenha(resultado.getString("Senha"));
			retorno.add(recepcionista);
		}
		recepcionistaDAO.fecharConexao();
		return retorno;
	}
	
	public void inserir(Recepcionista recepcionista) throws SQLException {
		String sql = "INSERT INTO Recepcionista(CPF, Nome, Telefone, Email, Login, Senha) VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = recepcionistaDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, recepcionista.getCpf());
		stmt.setString(2, recepcionista.getNome());
		stmt.setString(3, recepcionista.getTelefone());
		stmt.setString(4, recepcionista.getEmail());
		stmt.setString(5, recepcionista.getLogin());
		stmt.setString(6, recepcionista.getSenha());
		stmt.execute();
		recepcionistaDAO.fecharConexao();
	}
	
	public boolean alterar(Recepcionista recepcionista) throws SQLException {
		String sql = "UPDATE Recepcionista SET Nome=?, Telefone=?, Email=?, Login=?, Senha=? WHERE (CPF=?)";
		PreparedStatement stmt = recepcionistaDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, recepcionista.getCpf());
		stmt.setString(2, recepcionista.getNome());
		stmt.setString(3, recepcionista.getTelefone());
		stmt.setString(4, recepcionista.getEmail());
		stmt.setString(5, recepcionista.getLogin());
		stmt.setString(6, recepcionista.getSenha());
		boolean execucao = stmt.execute();
		recepcionistaDAO.fecharConexao();
		return execucao;
	}
	
	public boolean excluir(Recepcionista recepcionista) throws SQLException {
		String sql = "DELETE FROM Recepcionista WHERE (CPF=?)";
		PreparedStatement stmt = recepcionistaDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, recepcionista.getCpf());
		boolean execucao = stmt.execute();
		recepcionistaDAO.fecharConexao();
		return execucao;
	}
}


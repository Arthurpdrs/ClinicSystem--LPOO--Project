package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import core.model.Responsavel;

public class ResponsavelDAO {
	
FabricaConexao responsavelDAO = new FabricaConexao();
	
    public List<Responsavel> listar() throws SQLException {
    	String sql = "SELECT * FROM Responsavel";
		List<Responsavel> retorno = new ArrayList();
		PreparedStatement stmt = responsavelDAO.getConexao().prepareStatement(sql);
		ResultSet resultado = stmt.executeQuery();
		while(resultado.next()) {
			Responsavel responsavel = new Responsavel();
			responsavel.setCpf(resultado.getString("CPF"));
			responsavel.setNome(resultado.getString("Nome"));
			responsavel.setTelefone(resultado.getString("Telefone"));
			responsavel.setEmail(resultado.getString("Email"));
			retorno.add(responsavel);
		}
		responsavelDAO.fecharConexao();
		return retorno;
	}
	
	public void inserir(Responsavel responsavel) throws SQLException {
		String sql = "INSERT INTO Responsavel(CPF, Nome, Telefone, Email) VALUES(?, ?, ?, ?)";
		PreparedStatement stmt = responsavelDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, responsavel.getCpf());
		stmt.setString(2, responsavel.getNome());
		stmt.setString(3, responsavel.getTelefone());
		stmt.setString(4, responsavel.getEmail());
		stmt.execute();
		responsavelDAO.fecharConexao();
	}
	
	public void alterar(Responsavel responsavel) throws SQLException {
		String sql = "UPDATE Responsavel SET Nome=?, Telefone=?, Email=? WHERE (CPF=?)";
		PreparedStatement stmt = responsavelDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, responsavel.getCpf());
		stmt.setString(2, responsavel.getNome());
		stmt.setString(3, responsavel.getTelefone());
		stmt.setString(4, responsavel.getEmail());
		stmt.execute();
		responsavelDAO.fecharConexao();
	}
	
	public void remover(Responsavel responsavel) throws SQLException {
		String sql = "DELETE FROM Responsavel WHERE (CPF=?)";
		PreparedStatement stmt = responsavelDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, responsavel.getCpf());
		stmt.execute();
		responsavelDAO.fecharConexao();
	}
}

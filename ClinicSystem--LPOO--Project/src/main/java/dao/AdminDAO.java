package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import core.model.Admin;

public class AdminDAO {
	
FabricaConexao adminDAO = new FabricaConexao();
	
    public List<Admin> listar() throws SQLException {
    	String sql = "SELECT * FROM Administrador";
		List<Admin> retorno = new ArrayList();
		PreparedStatement stmt = adminDAO.getConexao().prepareStatement(sql);
		ResultSet resultado = stmt.executeQuery();
		while(resultado.next()) {
			Admin admin = new Admin();
			admin.setCpf(resultado.getString("CPF"));
			admin.setNome(resultado.getString("Nome"));
			admin.setTelefone(resultado.getString("Telefone"));
			admin.setEmail(resultado.getString("Email"));
			admin.setLogin(resultado.getString("Login"));
			admin.setSenha(resultado.getString("Senha"));
			retorno.add(admin);
		}
		adminDAO.fecharConexao();
		return retorno;
	}
	
	public boolean inserir(Admin admin) throws SQLException {
		String sql = "INSERT INTO Administrador(CPF, Nome, Telefone, Email, Login, Senha) VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = adminDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, admin.getCpf());
		stmt.setString(2, admin.getNome());
		stmt.setString(3, admin.getTelefone());
		stmt.setString(4, admin.getEmail());
		stmt.setString(5, admin.getLogin());
		stmt.setString(6, admin.getSenha());
		boolean execucao = stmt.execute();
		adminDAO.fecharConexao();
		return execucao;
	}
	
	public boolean alterar(Admin admin) throws SQLException {
		String sql = "UPDATE Administrador SET Nome=?, Telefone=?, Email=?, Login=?, Senha=? WHERE (CPF=?)";
		PreparedStatement stmt = adminDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, admin.getCpf());
		stmt.setString(2, admin.getNome());
		stmt.setString(3, admin.getTelefone());
		stmt.setString(4, admin.getEmail());
		stmt.setString(5, admin.getLogin());
		stmt.setString(6, admin.getSenha());
		boolean execucao = stmt.execute();
		adminDAO.fecharConexao();
		return execucao;
	}
	
	public boolean remover(Admin admin) throws SQLException {
		String sql = "DELETE FROM Administrador WHERE (CPF=?)";
		PreparedStatement stmt = adminDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, admin.getCpf());
		stmt.execute();
		boolean execucao = stmt.execute();
		adminDAO.fecharConexao();
		return execucao;
	}
}


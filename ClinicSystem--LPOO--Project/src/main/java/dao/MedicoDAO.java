package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import core.model.Medico;

public class MedicoDAO {
	
FabricaConexao medicoDAO = new FabricaConexao();
	
    public List<Medico> listar() throws SQLException {
    	String sql = "SELECT * FROM Medico";
		List<Medico> retorno = new ArrayList();
		PreparedStatement stmt = medicoDAO.getConexao().prepareStatement(sql);
		ResultSet resultado = stmt.executeQuery();
		while(resultado.next()) {
			Medico medico = new Medico();
			medico.setCpf(resultado.getString("CPF"));
			medico.setNome(resultado.getString("Nome"));
			medico.setTelefone(resultado.getString("Telefone"));
			medico.setEmail(resultado.getString("Email"));
			medico.setLogin(resultado.getString("Login"));
			medico.setSenha(resultado.getString("Senha"));
			medico.setCrm(resultado.getString("CRM"));
			medico.setEspecialidade(resultado.getString("Especialidade"));
			retorno.add(medico);
		}
		medicoDAO.fecharConexao();
		return retorno;
	}
	
    public List<String> listarEspecialidades() throws SQLException {
    	String sql = "SELECT DISTINCT Especialidade FROM Medico";
		List<String> retorno = new ArrayList();
		PreparedStatement stmt = medicoDAO.getConexao().prepareStatement(sql);
		ResultSet resultado = stmt.executeQuery();
		while(resultado.next()) {
			retorno.add(resultado.getString("Especialidade"));
		}
		medicoDAO.fecharConexao();
		return retorno;
	}
    
	public boolean inserir(Medico medico) throws SQLException {
		String sql = "INSERT INTO Medico(CPF, Nome, Telefone, Email, Login, Senha, CRM, Especialidade) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = medicoDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, medico.getCpf());
		stmt.setString(2, medico.getNome());
		stmt.setString(3, medico.getTelefone());
		stmt.setString(4, medico.getEmail());
		stmt.setString(5, medico.getLogin());
		stmt.setString(6, medico.getSenha());
		stmt.setString(7, medico.getCrm());
		stmt.setString(8, medico.getEspecialidade());
		boolean execucao = stmt.execute();
		medicoDAO.fecharConexao();
		return execucao;
	}
	
	public boolean alterar(Medico medico) throws SQLException {
		String sql = "UPDATE Medico SET Nome=?, Telefone=?, Email=?, Login=?, Senha=?, CRM=?, Especialidade=? WHERE (CPF=?)";
		PreparedStatement stmt = medicoDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, medico.getCpf());
		stmt.setString(2, medico.getNome());
		stmt.setString(3, medico.getTelefone());
		stmt.setString(4, medico.getEmail());
		stmt.setString(5, medico.getLogin());
		stmt.setString(6, medico.getSenha());
		stmt.setString(7, medico.getCrm());
		stmt.setString(8, medico.getEspecialidade());
		boolean execucao = stmt.execute();
		medicoDAO.fecharConexao();
		return execucao;
	}
	
	public boolean remover(Medico medico) throws SQLException {
		String sql = "DELETE FROM Medico WHERE (CPF=?)";
		PreparedStatement stmt = medicoDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, medico.getCpf());
		boolean execucao = stmt.execute();
		medicoDAO.fecharConexao();
		return execucao;
	}
}

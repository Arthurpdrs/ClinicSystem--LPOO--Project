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
	
    public List<Medico> filtrar(String cpf) throws SQLException {
    	String sql = "SELECT * FROM Medico WHERE CPF = ?";
		List<Medico> retorno = new ArrayList();
		PreparedStatement stmt = medicoDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, cpf);
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
    
    public Medico filtrarMedico(String cpf) throws SQLException {
    	String sql = "SELECT * FROM Medico WHERE CPF = ?";
		Medico medico = new Medico();
		PreparedStatement stmt = medicoDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, cpf);
		ResultSet resultado = stmt.executeQuery();
		if(resultado.next()) {
			medico.setCpf(resultado.getString("CPF"));
			medico.setNome(resultado.getString("Nome"));
			medico.setTelefone(resultado.getString("Telefone"));
			medico.setEmail(resultado.getString("Email"));
			medico.setLogin(resultado.getString("Login"));
			medico.setSenha(resultado.getString("Senha"));
			medico.setCrm(resultado.getString("CRM"));
			medico.setEspecialidade(resultado.getString("Especialidade"));
		}
		medicoDAO.fecharConexao();
		return medico;
	}
    
    public List<Medico> filtrarEspecialidade(String especialidade) throws SQLException {
    	String sql = "SELECT * FROM Medico WHERE Especialidade = ?";
		List<Medico> retorno = new ArrayList();
		PreparedStatement stmt = medicoDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, especialidade);
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
		stmt.execute();
		medicoDAO.fecharConexao();
		return true;
	}
	
	public boolean alterar(Medico medico) throws SQLException {
		String sql = "UPDATE Medico SET Nome=?, Telefone=?, Email=?, CRM=?, Especialidade=? WHERE (CPF=?)";
		PreparedStatement stmt = medicoDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, medico.getNome());
		stmt.setString(2, medico.getTelefone());
		stmt.setString(3, medico.getEmail());
		stmt.setString(4, medico.getCrm());
		stmt.setString(5, medico.getEspecialidade());
		stmt.setString(6, medico.getCpf());
		stmt.execute();
		medicoDAO.fecharConexao();
		return true;
	}
	
	public boolean excluir(Medico medico) throws SQLException {
		String sql = "DELETE FROM Medico WHERE (CPF=?)";
		PreparedStatement stmt = medicoDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, medico.getCpf());
		stmt.execute();
		medicoDAO.fecharConexao();
		return true;
	}
	
	public String totalMedico() throws SQLException {
		String sql = "SELECT COUNT(*) as Total FROM Medico";
		PreparedStatement count = medicoDAO.getConexao().prepareStatement(sql);
		ResultSet resultado = count.executeQuery();
		String retorno = "";
		if(resultado.next()){
			retorno = resultado.getString("Total");
			}
		medicoDAO.fecharConexao();
		return retorno;
	}
}

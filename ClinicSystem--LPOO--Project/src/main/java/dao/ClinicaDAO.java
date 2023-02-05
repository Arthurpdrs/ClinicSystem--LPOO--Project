package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.model.Clinica;

public class ClinicaDAO {
	FabricaConexao clinicaDAO = new FabricaConexao();
	

	public Clinica listar() throws SQLException {
			String sql = "SELECT Nome, Email, Telefone, Senha, Endereco FROM Clinica WHERE id = 1";
			Clinica dadosClinica = new Clinica();
			PreparedStatement select = clinicaDAO.getConexao().prepareStatement(sql);
			ResultSet resultado = select.executeQuery();
			while(resultado.next()) {
				dadosClinica.setNome(resultado.getString("Nome"));
				dadosClinica.setEmail(resultado.getString("Email"));
				dadosClinica.setTelefone(resultado.getString("Telefone"));
				dadosClinica.setSenha(resultado.getString("Senha"));
				dadosClinica.setEndereco(resultado.getString("Endereco"));
			}
			clinicaDAO.fecharConexao();
			return dadosClinica;
		} 
	
	public boolean alterar(Clinica clinica) throws SQLException{
		String sql = "UPDATE Clinica SET Nome=?, Telefone=?, Email=?, Senha = ?, Endereco = ? WHERE id = 1";
		PreparedStatement stmt = clinicaDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, clinica.getNome());
		stmt.setString(2, clinica.getTelefone());
		stmt.setString(3, clinica.getEmail());
		stmt.setString(4, clinica.getSenha());
		stmt.setString(4, clinica.getSenha());
		stmt.setString(5, clinica.getEndereco());
		stmt.execute();
		clinicaDAO.fecharConexao();
		return true;
	}

}

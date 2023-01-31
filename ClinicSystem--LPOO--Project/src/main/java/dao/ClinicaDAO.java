package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.model.Clinica;

public class ClinicaDAO extends FabricaConexao{
	FabricaConexao clinicaDAO = new FabricaConexao();
	

		public List<Clinica> listarDadosCLinica() {
			String sql = "SELECT * FROM Clinica";
			List<Clinica> retornoClinica = new ArrayList();
			try {
				PreparedStatement select = clinicaDAO.getConexao().prepareStatement(sql);
				ResultSet resultado = select.executeQuery();
				while(resultado.next()) {
					Clinica dadosClinica = new Clinica();
					dadosClinica.setNome(resultado.getString("Nome"));
					dadosClinica.setEmail(resultado.getString("Email"));
					dadosClinica.setTelefone(resultado.getString("Telefone"));
					dadosClinica.setSenha(resultado.getString("Senha"));
					dadosClinica.setEndereco(resultado.getString("Endereco"));
					retornoClinica.add(dadosClinica);
				}
			} catch (SQLException e) {
				System.out.println("Não foi possível listar os dados de Clinica!");
			} finally {
				clinicaDAO.fecharConexao();
			}
			
			return retornoClinica;
		} 
	
	public boolean atualizarDados(Clinica clinica) throws SQLException{
		String sql = "UPDATE Clinica SET Nome=?, Telefone=?, Email=?, Senha ?, Endereco = ?";
		
		try {
			PreparedStatement stmt = clinicaDAO.getConexao().prepareStatement(sql);
			stmt.setString(1, clinica.getNome());
			stmt.setString(2, clinica.getTelefone());
			stmt.setString(3, clinica.getEmail());
			stmt.setString(4, clinica.getSenha());
			stmt.setString(4, clinica.getSenha());
			stmt.setString(5, clinica.getEndereco());
			stmt.execute();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Não foi possível alterar os dados da Clinica!");
			return false;
			
		} finally {
			clinicaDAO.fecharConexao();
		}
		
	}
		

}

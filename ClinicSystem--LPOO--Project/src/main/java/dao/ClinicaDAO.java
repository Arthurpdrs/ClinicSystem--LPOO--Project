package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.model.Pessoa;
// falta criar o model de clinica

public class ClinicaDAO extends FabricaConexao{
	FabricaConexao clinicaDao = new FabricaConexao();
	

		public List<Clinica> listarDadosCLinica() {
			String sql = "SELECT * FROM Clinica";
			List<Clinica> retornoClinica = new ArrayList();
			try {
				PreparedStatement select = clinicaDao.getConexao().prepareStatement(sql);
				ResultSet resultado = select.executeQuery();
				while(resultado.next()) {
					Clinica dadosClinica = new Clinica();
					dadosClinica.setCpf(resultado.getString("Nome"));
					dadosClinica.setNome(resultado.getString("Email"));
					dadosClinica.setTelefone(resultado.getString("Telefone"));
					dadosClinica.setEmail(resultado.getString("Senha"));
					retornoClinica.add(dadosClinica);
					
					return retornoClinica;
				}
			} catch (SQLException e) {
				System.out.println("Não foi possível listar os dados de Clinica!");
			}

		} finally {
			clinicaDao.fecharConexao();
		}

	

	
	public boolean adcionarDados(Clinica clinica) {
		String sql = "INSERT INTO Pessoa(Nomw, Telefone, Email, Senha) VALUES(?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = clinicaDAO.getConexao().prepareStatement(sql);
			stmt.setString(1, clinica.getNome());
			stmt.setString(2, clinica.getTelefone());
			stmt.setString(3, clinica.getEmail());
			stmt.setString(4, clinica.getSenha());
			return true;
		} catch (SQLException e) {
			System.out.println("Não foi possível inserir os dados da Clinica");
			return false;	
		} finally {
			clinicaDao.fecharConexao();
		}
	
		
	}
	
	public boolean atualizarDados(Clinica clinica) throws SQLException{
		String sql = "UPDATE Clinica SET Nome=?, Telefone=?, Email=?, Senha ?";
		
		try {
			PreparedStatement stmt = clinicaDao.getConexao().prepareStatement(sql);
			stmt.setString(1, clinica.getNome());
			stmt.setString(2, clinica.getTelefone());
			stmt.setString(3, clinica.getEmail());
			stmt.setString(4, clinica.getSenha());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Não foi possível alterar os dados da Clinica!");
			return false;
		} finally {
			clinicaDao.fecharConexao();
		}
		
	}
		

}

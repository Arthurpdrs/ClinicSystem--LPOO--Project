package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import core.model.Clinica;
import core.model.Paciente;
import core.model.Responsavel;

public class ResponsavelDAO extends PessoaDAO{
	
	
	FabricaConexao conexao = new FabricaConexao();
	
	public boolean addResponsavelPaciente(Responsavel responsavel) throws SQLException {
		String sql = "INSERT INTO Responsavel(Pessoa_CPF) (SELECT CPF FROM Pessoa WHERE CPF = ?)";
		try {		
			PreparedStatement insert = conexao.getConexao().prepareStatement(sql);
			insert.setString(1, responsavel.getCpf());
			return insert.execute();	
		} finally {
			conexao.fecharConexao();
			
			
		}
	}
	

	public void excluirResponsavel(Responsavel responsavel) throws SQLException {
		String sql = "DELETE FROM Responsavel WHERE Pessoa_CPF = ?";
		try {
			PreparedStatement delete = conexao.getConexao().prepareStatement(sql);
			delete.setString(1, responsavel.getCpf());
			delete.execute();
		} catch (SQLException e) {
			System.out.println("Não foi possivel deletar o Paciente!");
		} finally {
			conexao.fecharConexao();

		}
	}
	

}

package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import core.model.Responsavel;

public class ResponsavelDAO extends PessoaDAO{
	
	PessoaDAO respondavelDao = new PessoaDAO();
	
	public boolean addResponsavelPaciente(Responsavel responsavel) throws SQLException {
		String sql = "INSERT INTO Responsavel(Pessoa_CPF) (SELECT CPF FROM Pessoa WHERE CPF = ?)";
		try {		
			PreparedStatement insert = respondavelDao.getConexao().prepareStatement(sql);
			insert.setString(1, responsavel.getCpf());
			return insert.execute();	
		} finally {
			respondavelDao.fecharConexao();
			
			
		}
	}
	

	

}

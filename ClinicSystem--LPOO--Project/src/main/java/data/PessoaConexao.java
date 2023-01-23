package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaConexao extends FabricaConexao{
	FabricaConexao pessoa = new FabricaConexao();
	
	
	public boolean addPessoa(String cpf, String nome, String telefone, String email) throws SQLException {
		try {
			PreparedStatement insert = pessoa.getConexao().prepareStatement("INSERT INTO Pessoa(CPF, Nome, Telefone, Email) VALUES(?, ?, ?, ?)");
			insert.setString(1, cpf);
			insert.setString(2, nome);
			insert.setString(3, telefone);
			insert.setString(4, email);
			return insert.execute();	
		} finally {
			pessoa.fecharConexao();
		}
		
	}
	
	public static void main(String [] args ) throws SQLException{
		PessoaConexao teste = new PessoaConexao();
		teste.addPessoa("71567645634", "Fernando Silveira", "81987574534", "fernado333@gmail.com");
		
		
	}

}

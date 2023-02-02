package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.model.Paciente;
import core.model.Responsavel;


public class PacienteDAO extends PessoaDAO {
	PessoaDAO pacienteDAO = new PessoaDAO(); 
	FabricaConexao conexao = new FabricaConexao();
	String Responsavel_Pessoa_CPF = null;
	
	
	
	
	
	public List<Paciente> listaPaciente() throws SQLException{
		String sql = "SELECT * FROM Paciente";
		List<Paciente> retornoLista = new ArrayList();
		try {
			PreparedStatement select = conexao.getConexao().prepareStatement(sql);
			ResultSet resultado = select.executeQuery();
			while(resultado.next()) {
				Paciente paciente = new Paciente();
				paciente.setCpf(resultado.getString("CPF"));
				paciente.setNome(resultado.getString("Nome"));
				paciente.setTelefone(resultado.getString("Telefone"));
				paciente.setEmail(resultado.getString("Email"));
				retornoLista.add(paciente);
				
				
			}
		} catch (SQLException e) {
			System.out.println("Não foi possível listar os dados da pessoa!");
		}
		finally {
				conexao.fecharConexao();
				
	}
		return retornoLista;

		
}
	
	
	
	

	
	public void addPaciente(Paciente paciente, Responsavel responsavel) {
		String sql = "INSERT INTO Paciente(Tipo_sanguineo, Alergia, Data_nascimento, Pessoa_CPF, Responsavel_Pessoa_CPF) VALUES(?, ?, str_to_date(?,'%d-%m-%Y'), ?, ?)";
		try {
			
			PreparedStatement insert = conexao.getConexao().prepareStatement(sql);
			insert.setString(1, paciente.getTipoSanguineo());
			insert.setString(2, paciente.getAlergia());
			insert.setString(3, paciente.getDataNascimento()); //Comentar com arthur
			insert.setString(4, paciente.getCpf());
			insert.setString(5, responsavel.getCpf());
			insert.execute();
		} catch (SQLException e) {
			System.out.println("Não foi possível Inserir os dados do Paciente!");
		} finally {
			conexao.fecharConexao();
			
		}
		
	}
	
	
	

	public List<Paciente> visualizarPaciente(Paciente paciente) throws SQLException {
		String sql = "SELECT * FROM Paciente WHERE Pessoa_CPF = ? ";
		List<Paciente> retornoDados = new ArrayList();
		try {
			PreparedStatement select = conexao.getConexao().prepareStatement(sql);
			select.setString(1, paciente.getCpf());
			ResultSet resultado = select.executeQuery();
			
			while(resultado.next()) {
				Paciente retornoPaciente = new Paciente();
				retornoPaciente.setCpf(resultado.getString("CPF"));
				retornoPaciente.setNome(resultado.getString("Nome"));
				retornoPaciente.setTelefone(resultado.getString("Telefone"));
				retornoPaciente.setEmail(resultado.getString("Email"));
				retornoDados.add(retornoPaciente);
				
				}
			
		} catch (SQLException e) {
			System.out.println("Não foi possivel visualizar o Paciente!");
			
		} finally {
			conexao.fecharConexao();
				
		}
		return retornoDados;
		
		
	}

	
	public void excluirPaciente(Paciente paciente) throws SQLException {
		String sql = "DELETE FROM Paciente WHERE Pessoa_CPF = ?";
		try {
			PreparedStatement delete = conexao.getConexao().prepareStatement(sql);
			delete.setString(1, paciente.getCpf());
			delete.execute();
		} catch (SQLException e) {
			System.out.println("Não foi possivel deletar o Paciente!");
		} finally {
			conexao.fecharConexao();

		}
		
		
	}
	


	

	
	public String visualizarAgenda() {
		String sql =
		return null;}

	
	public String pacienteDia() {
		return null;}
	



		
	
	}

}

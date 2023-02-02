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

		PreparedStatement select = conexao.getConexao().prepareStatement(sql);
		ResultSet resultado = select.executeQuery();
		
		while(resultado.next()) {
			Paciente paciente = new Paciente();
			paciente.setCpf(resultado.getString("CPF"));
			paciente.setNome(resultado.getString("Nome"));
			paciente.setTelefone(resultado.getString("Telefone"));
			paciente.setEmail(resultado.getString("Email"));
			paciente.setEndereco(resultado.getString("Endereco"));
			
			Responsavel responsavel = new Responsavel();
			PreparedStatement selectResponsavel = conexao.getConexao().prepareStatement(sql);
			ResultSet resultadoResponsavel = selectResponsavel.executeQuery();
			while(resultadoResponsavel.next()) {
				responsavel.setCpf(resultadoResponsavel.getString("CPF"));
				responsavel.setEmail(resultadoResponsavel.getString("Email"));
				responsavel.setNome(resultadoResponsavel.getString("Nome"));
				responsavel.setTelefone(resultadoResponsavel.getString("Telefone"));
			}
			paciente.setResponsavel(responsavel);
			retornoLista.add(paciente);			
		}
		
		conexao.fecharConexao();
		return retornoLista;

		}
		
	public void addPaciente(Paciente paciente, Responsavel responsavel) throws SQLException {
		String sql = "INSERT INTO Paciente(Nome, Tipo_sanguineo, Alergia, Data_nascimento, CPF, Responsavel_CPF, Endereco) VALUES(?, ?, str_to_date(?,'%d-%m-%Y'), ?, ?, ?)";
		PreparedStatement insert = conexao.getConexao().prepareStatement(sql);
		insert.setString(1, paciente.getTipoSanguineo());
		insert.setString(2, paciente.getAlergia());
		insert.setString(3, paciente.getDataNascimento());
		insert.setString(4, paciente.getCpf());
		insert.setString(5, responsavel.getCpf());
		insert.setString(6, paciente.getEndereco());
		insert.execute();
		
		conexao.fecharConexao();
	}
	
	
	

	public List<Paciente> visualizarPaciente(Paciente paciente) throws SQLException {
		String sql = "SELECT * FROM Paciente WHERE CPF = ? ";
		List<Paciente> retornoDados = new ArrayList();
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
			
		conexao.fecharConexao();	
		return retornoDados;
		
		
	}

	
	public void excluirPaciente(Paciente paciente) throws SQLException {
		String sql = "DELETE FROM Paciente WHERE CPF = ?";
		PreparedStatement delete = conexao.getConexao().prepareStatement(sql);
		delete.setString(1, paciente.getCpf());
		delete.execute();
		
		conexao.fecharConexao();
	}
	


	

	
	public String visualizarAgenda() {
		String sql = "";
		return "";
		
	}

	
	public String pacienteDia() {
		return null;
		
		}
	
}

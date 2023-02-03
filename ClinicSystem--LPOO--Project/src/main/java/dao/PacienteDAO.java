package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.model.Paciente;
import core.model.Responsavel;


public class PacienteDAO {
	FabricaConexao conexao = new FabricaConexao();
	String Responsavel_CPF = null;
	
	public List<Paciente> listar() throws SQLException{
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
			paciente.setTipoSanguineo(resultado.getString("Tipo_sanguineo"));
			paciente.setAlergia(resultado.getString("Alergia"));
			paciente.setDataNascimento(resultado.getString("Data_nascimento"));
			paciente.setObservacao(resultado.getString("Observacao"));
			
			Responsavel responsavel = new Responsavel();
			if (resultado.getString("Responsavel_CPF") != null) {
				String sqlResponsavel = "SELECT CPF, Nome, Telefone FROM Responsavel WHERE CPF = ?";
				PreparedStatement selectResponsavel = conexao.getConexao().prepareStatement(sqlResponsavel);
				selectResponsavel.setString(1, resultado.getString("Responsavel_CPF"));
				ResultSet resultadoResponsavel = selectResponsavel.executeQuery();
				while (resultadoResponsavel.next()) {
					responsavel.setNome(resultadoResponsavel.getString("Nome"));
					responsavel.setCpf(resultadoResponsavel.getString("CPF"));
					responsavel.setTelefone(resultadoResponsavel.getString("Telefone"));
				}
			} else {
				responsavel.setCpf("Não informado");
				responsavel.setNome("Não informado");
				responsavel.setTelefone("Não informado");
			}
			paciente.setResponsavel(responsavel);
			
			retornoLista.add(paciente);			
		}
		
		conexao.fecharConexao();
		return retornoLista;

		}
	
	public List<Paciente> filtrar(String cpf) throws SQLException{
		String sql = "SELECT * FROM Paciente WHERE CPF = ?";
		List<Paciente> retornoLista = new ArrayList();

		PreparedStatement select = conexao.getConexao().prepareStatement(sql);
		select.setString(1, cpf);
		ResultSet resultado = select.executeQuery();
		
		while(resultado.next()) {
			Paciente paciente = new Paciente();
			paciente.setCpf(resultado.getString("CPF"));
			paciente.setNome(resultado.getString("Nome"));
			paciente.setTelefone(resultado.getString("Telefone"));
			paciente.setEmail(resultado.getString("Email"));
			paciente.setEndereco(resultado.getString("Endereco"));
			paciente.setTipoSanguineo(resultado.getString("Tipo_sanguineo"));
			paciente.setAlergia(resultado.getString("Alergia"));
			paciente.setDataNascimento(resultado.getString("Data_nascimento"));
			paciente.setObservacao(resultado.getString("Observacao"));
			
			Responsavel responsavel = new Responsavel();
			if (resultado.getString("Responsavel_CPF") != null) {
				String sqlResponsavel = "SELECT CPF, Nome, Telefone FROM Responsavel WHERE CPF = ?";
				PreparedStatement selectResponsavel = conexao.getConexao().prepareStatement(sqlResponsavel);
				selectResponsavel.setString(1, resultado.getString("Responsavel_CPF"));
				ResultSet resultadoResponsavel = selectResponsavel.executeQuery();
				while (resultadoResponsavel.next()) {
					responsavel.setNome(resultadoResponsavel.getString("Nome"));
					responsavel.setCpf(resultadoResponsavel.getString("CPF"));
					responsavel.setTelefone(resultadoResponsavel.getString("Telefone"));
				}
			} else {
				responsavel.setCpf("Não informado");
				responsavel.setNome("Não informado");
				responsavel.setTelefone("Não informado");
			}
			paciente.setResponsavel(responsavel);
			
			retornoLista.add(paciente);			
		}
		
		conexao.fecharConexao();
		return retornoLista;

		}
	
	public boolean adicionar(Paciente paciente, Responsavel responsavel) throws SQLException {
		String sql = "INSERT INTO Paciente(Nome, Tipo_sanguineo, Alergia, Data_nascimento, CPF, Responsavel_CPF, Endereco, Observacao) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement insert = conexao.getConexao().prepareStatement(sql);
		insert.setString(1, paciente.getNome());
		insert.setString(2, paciente.getTipoSanguineo());
		insert.setString(3, paciente.getAlergia());
		insert.setString(4, paciente.getDataNascimento());
		insert.setString(5, paciente.getCpf());
		insert.setString(6, responsavel.getCpf());
		insert.setString(7, paciente.getEndereco());
		insert.setString(8, paciente.getObservacao());
		boolean execucao = insert.execute();
		conexao.fecharConexao();
		return execucao;
	}
	
	public boolean alterar(Paciente paciente, Responsavel responsavel) throws SQLException {
		String sql = "UPDATE Paciente SET Nome = ?, Tipo_sanguineo = ?, Alergia = ?, Data_nascimento = ?, Responsavel_CPF = ?, Endereco = ?, Observacao = ? WHERE CPF = ?";
			PreparedStatement insert = conexao.getConexao().prepareStatement(sql);
			insert.setString(1, paciente.getNome());
			insert.setString(2, paciente.getTipoSanguineo());
			insert.setString(3, paciente.getAlergia());
			insert.setString(4, paciente.getDataNascimento());
			insert.setString(5, responsavel.getCpf());
			insert.setString(6, paciente.getEndereco());
			insert.setString(7, paciente.getObservacao());
			insert.setString(8, paciente.getCpf());
			boolean execucao = insert.execute();
			conexao.fecharConexao();
			return execucao;
	}
	
	
	

	public List<Paciente> filtrar(Paciente paciente) throws SQLException {
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

	
	public boolean excluir(String cpf) throws SQLException {
		String sql = "DELETE FROM Paciente WHERE CPF = ?";
		PreparedStatement delete = conexao.getConexao().prepareStatement(sql);
		delete.setString(1, cpf);
		boolean execucao = delete.execute();
		conexao.fecharConexao();
		return execucao;
	}
	


	

	
	public String visualizarAgenda() {
		String sql = "";
		return "";
		
	}

	
	public String pacienteDia() {
		return null;
		
		}
	
}

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.model.Consulta;
import core.model.Medico;
import core.model.Paciente;
import core.model.Responsavel;


public class PacienteDAO {
	FabricaConexao pacienteDAO = new FabricaConexao();
	String Responsavel_CPF = null;
	
	public List<Paciente> listar() throws SQLException{
		String sql = "SELECT * FROM Paciente";
		List<Paciente> retornoLista = new ArrayList();

		PreparedStatement select = pacienteDAO.getConexao().prepareStatement(sql);
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
				PreparedStatement selectResponsavel = pacienteDAO.getConexao().prepareStatement(sqlResponsavel);
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
		
		pacienteDAO.fecharConexao();
		return retornoLista;

		}
	
    public Paciente filtrarPaciente(String cpf) throws SQLException {
    	String sql = "SELECT Nome FROM Paciente WHERE CPF = ?";
		Paciente paciente = new Paciente();
		PreparedStatement stmt = pacienteDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, cpf);
		ResultSet resultado = stmt.executeQuery();
		if(resultado.next()) {
			paciente.setNome(resultado.getString("Nome"));
		}
		pacienteDAO.fecharConexao();
		return paciente;
	}
	
	public List<Paciente> filtrar(String cpf) throws SQLException{
		String sql = "SELECT * FROM Paciente WHERE CPF = ?";
		List<Paciente> retornoLista = new ArrayList();
		
		PreparedStatement select = pacienteDAO.getConexao().prepareStatement(sql);
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
				PreparedStatement selectResponsavel = pacienteDAO.getConexao().prepareStatement(sqlResponsavel);
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
		
		pacienteDAO.fecharConexao();
		return retornoLista;

		}
	
	public boolean adicionar(Paciente paciente, Responsavel responsavel) throws SQLException {
		String sql = "INSERT INTO Paciente(Nome, Tipo_sanguineo, Alergia, Data_nascimento, CPF, Responsavel_CPF, Endereco, Observacao, Telefone, Email) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		String cpfResponsavel = "";
		
		if(responsavel != null) {
			cpfResponsavel = responsavel.getCpf();
		}
		
		PreparedStatement insert = pacienteDAO.getConexao().prepareStatement(sql);
		insert.setString(1, paciente.getNome());
		insert.setString(2, paciente.getTipoSanguineo());
		insert.setString(3, paciente.getAlergia());
		insert.setString(4, paciente.getDataNascimento());
		insert.setString(5, paciente.getCpf());
		insert.setString(6, cpfResponsavel);
		insert.setString(7, paciente.getEndereco());
		insert.setString(8, paciente.getObservacao());
		insert.setString(9, paciente.getTelefone());
		insert.setString(10, paciente.getEmail());
	    insert.execute();
		pacienteDAO.fecharConexao();
		return true;
	}
	
	public boolean alterar(Paciente paciente, Responsavel responsavel) throws SQLException {
		String sql = "UPDATE Paciente SET Nome = ?, Tipo_sanguineo = ?, Alergia = ?, Data_nascimento = ?, Responsavel_CPF = ?, Endereco = ?, Observacao = ?, Email = ? WHERE CPF = ?";
			PreparedStatement insert = pacienteDAO.getConexao().prepareStatement(sql);
			insert.setString(1, paciente.getNome());
			insert.setString(2, paciente.getTipoSanguineo());
			insert.setString(3, paciente.getAlergia());
			insert.setString(4, paciente.getDataNascimento());
			insert.setString(5, responsavel.getCpf());
			insert.setString(6, paciente.getEndereco());
			insert.setString(7, paciente.getObservacao());
			insert.setString(8, paciente.getEmail());
			insert.setString(9, paciente.getCpf());
			insert.execute();
			pacienteDAO.fecharConexao();
			return true;
	}
	
	
	

	public List<Paciente> filtrar(Paciente paciente) throws SQLException {
		String sql = "SELECT * FROM Paciente WHERE CPF = ? ";
		List<Paciente> retornoDados = new ArrayList();
		PreparedStatement select = pacienteDAO.getConexao().prepareStatement(sql);
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
			
		pacienteDAO.fecharConexao();	
		return retornoDados;
		
		
	}

	public boolean excluir(String cpf) throws SQLException {
		String sql = "DELETE FROM Paciente WHERE CPF = ?";
		PreparedStatement delete = pacienteDAO.getConexao().prepareStatement(sql);
		delete.setString(1, cpf);
		delete.execute();
		pacienteDAO.fecharConexao();
		return true;
	}
	


	
	public String totalPacientes() throws SQLException {
		String sql = "SELECT COUNT(*) as Total FROM Paciente";
		PreparedStatement count = pacienteDAO.getConexao().prepareStatement(sql);
		ResultSet resultado = count.executeQuery();
		String retorno = "";
		if(resultado.next()){
			retorno = resultado.getString("Total");
		}

		pacienteDAO.fecharConexao();
		return retorno;
	}

}

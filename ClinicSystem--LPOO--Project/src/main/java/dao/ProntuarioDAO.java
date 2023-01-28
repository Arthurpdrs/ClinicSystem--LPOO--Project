package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Prontuario;

public class ProntuarioDAO {
	
	FabricaConexao prontuarioDAO = new FabricaConexao();
	
    public List<Prontuario> listar() {
    	String sql = "SELECT * FROM Prontuario";
		List<Prontuario> retorno = new ArrayList();
		try {
			PreparedStatement stmt = prontuarioDAO.getConexao().prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Prontuario prontuario = new Prontuario();
				prontuario.setPaciente(resultado.getString("Paciente_Pessoa_CPF"));
				prontuario.setMedico(resultado.getString("Medico_Funcionario_Pessoa_CPF"));
				prontuario.setQueixa(resultado.getString("Queixa"));
				prontuario.setPrescricao(resultado.getString("Prescricao"));
				prontuario.setObservacao(resultado.getString("Observacao"));
				prontuario.setData(resultado.getDate("Data_prontuario"));
				retorno.add(prontuario);
			}
		} catch (SQLException e) {
			System.out.println("Não foi possível listar os dados do prontuário!");
		}
		return retorno;
	}
	
	public boolean inserir(Prontuario prontuario) {
		String sql = "INSERT INTO Prontuario(Paciente_Pessoa_CPF, Medico_Funcionario_Pessoa_CPF, Queixa, Prescricao, Observacao, Data_prontuario) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = prontuarioDAO.getConexao().prepareStatement(sql);
			stmt.setString(1, prontuario.getPaciente());
			stmt.setString(2, prontuario.getMedico());
			stmt.setString(3, prontuario.getQueixa());
			stmt.setString(4, prontuario.getPrescricao());
			stmt.setString(5, prontuario.getObservacao());
			stmt.setDate(6, prontuario.getData());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Não foi possível inserir os dados do prontuário!");
			return false;
		}
	}
	
	public boolean alterar(Prontuario prontuario) {
		String sql = "UPDATE Prontuario SET Queixa=?, Prescricao=?, Observacao=?, Data_prontuario=? WHERE (Paciente_Pessoa_CPF=? AND Medico_Funcionario_Pessoa_CPF=?)";
		try {
			PreparedStatement stmt = prontuarioDAO.getConexao().prepareStatement(sql);
			stmt.setString(3, prontuario.getQueixa());
			stmt.setString(4, prontuario.getPrescricao());
			stmt.setString(5, prontuario.getObservacao());
			stmt.setDate(6, prontuario.getData());
			stmt.setString(1, prontuario.getPaciente());
			stmt.setString(2, prontuario.getMedico());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Não foi possível alterar os dados do prontuário!");
			return false;
		}
	}
	
	public boolean remover(Prontuario prontuario) {
		String sql = "DELETE FROM Prontuario WHERE (Paciente_Pessoa_Cpf=? AND Medico_Funcionario_Pessoa_CPF=?)";
		try {
			PreparedStatement stmt = prontuarioDAO.getConexao().prepareStatement(sql);
			stmt.setString(1, prontuario.getPaciente());
			stmt.setString(2, prontuario.getMedico());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Não foi possível deletar os dados do prontuário!");
			return false;
		}
	}
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import core.model.Medico;
import core.model.Paciente;
import core.model.Prontuario;

public class ProntuarioDAO {
	
	FabricaConexao prontuarioDAO = new FabricaConexao();
	
    public List<Prontuario> listar() throws SQLException {
    	String sql = "SELECT * FROM Prontuario";
		List<Prontuario> retorno = new ArrayList();
		PreparedStatement stmt = prontuarioDAO.getConexao().prepareStatement(sql);
		ResultSet resultado = stmt.executeQuery();
		while(resultado.next()) {
			Prontuario prontuario = new Prontuario();
			Paciente paciente = new Paciente();
			Medico medico = new Medico();
			prontuario.setPaciente(paciente);
			paciente.setCpf(resultado.getString("Paciente_CPF"));
			prontuario.setMedico(medico);
			medico.setCpf(resultado.getString("Medico_CPF"));
			prontuario.setQueixa(resultado.getString("Queixa"));
			prontuario.setPrescricao(resultado.getString("Prescricao"));
			prontuario.setObservacao(resultado.getString("Observacao"));
			prontuario.setData(resultado.getDate("Data_prontuario"));
			retorno.add(prontuario);
		}
		prontuarioDAO.fecharConexao();
		return retorno;
	}
	
	public void inserir(Prontuario prontuario) throws SQLException {
		String sql = "INSERT INTO Prontuario(Paciente_CPF, Medico_CPF, Queixa, Prescricao, Observacao, Data_prontuario) VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = prontuarioDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, prontuario.getPaciente().getCpf());
		stmt.setString(2, prontuario.getMedico().getCpf());
		stmt.setString(3, prontuario.getQueixa());
		stmt.setString(4, prontuario.getPrescricao());
		stmt.setString(5, prontuario.getObservacao());
		stmt.setDate(6, prontuario.getData());
		stmt.execute();
		prontuarioDAO.fecharConexao();
	}
	
	public void alterar(Prontuario prontuario) throws SQLException {
		String sql = "UPDATE Prontuario SET Queixa=?, Prescricao=?, Observacao=?, Data_prontuario=? WHERE (Paciente_CPF=? AND Medico_CPF=?)";
		PreparedStatement stmt = prontuarioDAO.getConexao().prepareStatement(sql);
		stmt.setString(3, prontuario.getQueixa());
		stmt.setString(4, prontuario.getPrescricao());
		stmt.setString(5, prontuario.getObservacao());
		stmt.setDate(6, prontuario.getData());
		stmt.setString(1, prontuario.getPaciente().getCpf());
		stmt.setString(2, prontuario.getMedico().getCpf());
		stmt.execute();
		prontuarioDAO.fecharConexao();
	}
	
	public void remover(Prontuario prontuario) throws SQLException {
		String sql = "DELETE FROM Prontuario WHERE (Paciente_Cpf=? AND Medico_CPF=?)";
		PreparedStatement stmt = prontuarioDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, prontuario.getPaciente().getCpf());
		stmt.setString(2, prontuario.getMedico().getCpf());
		stmt.execute();
		prontuarioDAO.fecharConexao();
	}
}

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
            paciente.setNome(resultado.getString("Paciente_Nome"));
			prontuario.setMedico(medico);
			medico.setNome(resultado.getString("Medico_Nome"));
            medico.setEspecialidade(resultado.getString("Medico_Especialidade"));
			prontuario.setQueixa(resultado.getString("Queixa"));
			prontuario.setPrescricao(resultado.getString("Prescricao"));
			prontuario.setObservacao(resultado.getString("Observacao"));
			prontuario.setData(resultado.getString("Data_prontuario"));
			retorno.add(prontuario);
		}
		prontuarioDAO.fecharConexao();
		return retorno;
	}
	
        public List<Prontuario> filtrar(String cpf) throws SQLException {
    	String sql = "SELECT * FROM Prontuario WHERE Paciente_CPF = ?";
		List<Prontuario> retorno = new ArrayList();
		PreparedStatement stmt = prontuarioDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, cpf);
        ResultSet resultado = stmt.executeQuery();
		while(resultado.next()) {
			Prontuario prontuario = new Prontuario();
			Paciente paciente = new Paciente();
			Medico medico = new Medico();
			prontuario.setPaciente(paciente);
			paciente.setCpf(resultado.getString("Paciente_CPF"));
            paciente.setNome(resultado.getString("Paciente_Nome"));
			prontuario.setMedico(medico);
			medico.setNome(resultado.getString("Medico_Nome"));
            medico.setEspecialidade(resultado.getString("Medico_Especialidade"));
			prontuario.setQueixa(resultado.getString("Queixa"));
			prontuario.setPrescricao(resultado.getString("Prescricao"));
			prontuario.setObservacao(resultado.getString("Observacao"));
			prontuario.setData(resultado.getString("Data_prontuario"));
			retorno.add(prontuario);
		}
		prontuarioDAO.fecharConexao();
		return retorno;
	}

	public boolean inserir(Prontuario prontuario) throws SQLException {
		String sql = "INSERT INTO Prontuario(Paciente_CPF, Paciente_Nome, Medico_Nome, Medico_Especialidade, Queixa, Prescricao, Observacao, Data_prontuario) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = prontuarioDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, prontuario.getPaciente().getCpf());
		stmt.setString(2, prontuario.getPaciente().getNome());
                stmt.setString(3, prontuario.getMedico().getNome());
                stmt.setString(4, prontuario.getMedico().getEspecialidade());
		stmt.setString(5, prontuario.getQueixa());
		stmt.setString(6, prontuario.getPrescricao());
		stmt.setString(7, prontuario.getObservacao());
		stmt.setString(8, prontuario.getData());
		boolean execucao = stmt.execute();
		prontuarioDAO.fecharConexao();
		return execucao;
	}

}

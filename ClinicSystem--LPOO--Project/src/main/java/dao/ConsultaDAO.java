package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import core.model.Consulta;
import core.model.Medico;
import core.model.Paciente;
import core.model.Pessoa;

public class ConsultaDAO {
	
	FabricaConexao consultaDAO = new FabricaConexao();
	
    public List<Consulta> listar() throws SQLException {
    	String sql = "SELECT * FROM Consulta";
		List<Consulta> retorno = new ArrayList();
		PreparedStatement stmt = consultaDAO.getConexao().prepareStatement(sql);
		ResultSet resultado = stmt.executeQuery();
		while(resultado.next()) {
			Consulta consulta = new Consulta();
			Paciente paciente = new Paciente();
			Medico medico = new Medico();
			consulta.setPaciente(paciente);
			paciente.setCpf(resultado.getString("Paciente_CPF"));
			consulta.setMedico(medico);
			medico.setCpf(resultado.getString("Medico_CPF"));
			consulta.setDataConsulta(resultado.getString("Data_consulta"));
			consulta.setValor(resultado.getString("Valor"));
			consulta.setPago(resultado.getString("Pago"));
			consulta.setHorario(resultado.getString("Hora_consulta"));
			retorno.add(consulta);
		}
		consultaDAO.fecharConexao();
		return retorno;
	}
	
	public boolean inserir(Consulta consulta) throws SQLException {
		String sql = "INSERT INTO Consulta(Paciente_CPF, Medico_CPF, Data_consulta, Valor, Pago, Hora_consulta) VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = consultaDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, consulta.getPaciente().getCpf());
		stmt.setString(2, consulta.getMedico().getCpf());
		stmt.setString(3, consulta.getDataConsulta());
		stmt.setString(4, consulta.getValor());
		stmt.setString(5, consulta.getPago());
		stmt.setString(6, consulta.getHorario());
		boolean execucao = stmt.execute();
		consultaDAO.fecharConexao();
		return execucao;
	}
	
	public boolean alterar(Consulta consulta) throws SQLException {
		String sql = "UPDATE Consulta SET Data_consulta=?, Valor=?, Pago=?, Hora_consulta=? WHERE (Paciente_CPF=? AND Medico_CPF=?)";
		PreparedStatement stmt = consultaDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, consulta.getPaciente().getCpf());
		stmt.setString(2, consulta.getMedico().getCpf());
		stmt.setString(3, consulta.getDataConsulta());
		stmt.setString(4, consulta.getValor());
		stmt.setString(5, consulta.getPago());
		stmt.setString(6, consulta.getHorario());
		boolean execucao = stmt.execute();
		consultaDAO.fecharConexao();
		return execucao;
	}
	
	public boolean remover(Consulta consulta) throws SQLException {
		String sql = "DELETE FROM Consulta WHERE (Paciente_CPF=? AND Medico_CPF=?)";
		PreparedStatement stmt = consultaDAO.getConexao().prepareStatement(sql);
		stmt.setString(1, consulta.getPaciente().getCpf());
		stmt.setString(2, consulta.getMedico().getCpf());
		boolean execucao = stmt.execute();
		consultaDAO.fecharConexao();
		return execucao;
	}
	
	public String TotalConsultas() throws SQLException {
		Date data = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataAtual = dateFormat.format(data);
		String sql = "SELECT COUNT(*) as Data_consulta FROM Consulta WHERE Data_consulta= ?";
		PreparedStatement count = consultaDAO.getConexao().prepareStatement(sql);
		count.setString(1, dataAtual);
		ResultSet resultado = count.executeQuery();
		String retorno = "";
		if(resultado.next()){
			retorno = resultado.getString("Data_consulta");
		}

		consultaDAO.fecharConexao();
		return retorno;
	}
}

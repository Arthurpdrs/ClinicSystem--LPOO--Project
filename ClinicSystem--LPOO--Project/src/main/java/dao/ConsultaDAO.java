package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Consulta;

public class ConsultaDAO {
	
	FabricaConexao consultaDAO = new FabricaConexao();
	
    public List<Consulta> listar() {
    	String sql = "SELECT * FROM Consulta";
		List<Consulta> retorno = new ArrayList();
		try {
			PreparedStatement stmt = consultaDAO.getConexao().prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Consulta consulta = new Consulta();
				consulta.setPaciente(resultado.getString("Paciente_Pessoa_CPF"));
				consulta.setMedico(resultado.getString("Medico_Funcionario_Pessoa_CPF"));
				consulta.setDataConsulta(resultado.getDate("Data_consulta"));
				consulta.setValor(resultado.getDouble("Valor"));
				consulta.setPago(resultado.getBoolean("Pago"));
				consulta.setHoraConsulta(resultado.getTime("Hora_consulta"));
				retorno.add(consulta);
			}
		} catch (SQLException e) {
			System.out.println("Não foi possível listar os dados da consulta!");
		}
		return retorno;
	}
	
	public boolean inserir(Consulta consulta) {
		String sql = "INSERT INTO Consulta(Paciente_Pessoa_CPF, Medico_Funcionario_Pessoa_CPF, Data_consulta, Valor, Pago, Hora_consulta) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = consultaDAO.getConexao().prepareStatement(sql);
			stmt.setString(1, consulta.getPaciente());
			stmt.setString(2, consulta.getMedico());
			stmt.setDate(3, consulta.getDataConsulta());
			stmt.setDouble(4, consulta.getValor());
			stmt.setBoolean(5, consulta.getPago());
			stmt.setTime(6, consulta.getHoraConsulta());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Não foi possível inserir os dados da consulta!");
			return false;
		}
	}
	
	public boolean alterar(Consulta consulta) {
		String sql = "UPDATE Consulta SET Data_consulta=?, Valor=?, Pago=?, Hora_consulta=? WHERE (Paciente_Pessoa_CPF=? AND Medico_Funcionario_Pessoa_CPF=?)";
		try {
			PreparedStatement stmt = consultaDAO.getConexao().prepareStatement(sql);
			stmt.setDate(3, consulta.getDataConsulta());
			stmt.setDouble(4, consulta.getValor());
			stmt.setBoolean(5, consulta.getPago());
			stmt.setTime(6, consulta.getHoraConsulta());
			stmt.setString(1, consulta.getPaciente());
			stmt.setString(2, consulta.getMedico());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Não foi possível alterar os dados da consulta!");
			return false;
		}
	}
	
	public boolean remover(Consulta consulta) {
		String sql = "DELETE FROM Consulta WHERE (Paciente_Pessoa_CPF=? AND Medico_Funcionario_Pessoa_CPF=?)";
		try {
			PreparedStatement stmt = consultaDAO.getConexao().prepareStatement(sql);
			stmt.setString(1, consulta.getPaciente());
			stmt.setString(2, consulta.getMedico());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Não foi possível deletar os dados da consulta!");
			return false;
		}
	}
}

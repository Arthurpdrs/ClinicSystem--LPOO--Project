package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDAO extends PessoaDAO {
	PessoaDAO paciente = new PessoaDAO(); 
	String Responsavel_Pessoa_CPF = null;
	
	
	public boolean addPaciente(String Tipo_sanguineo, String Alergia, String Data_nascimento) throws SQLException {
		try {
			String Pessoa_CPF = CPF;
			PreparedStatement insert = paciente.getConexao().prepareStatement("INSERT INTO Paciente(Tipo_sanguineo, Alergia, Data_nascimento, Pessoa_CPF, Responsavel_Pessoa_CPF) VALUES(?, ?, str_to_date(?,'%d-%m-%Y'), ?, ?)");
			insert.setString(1, Tipo_sanguineo);
			insert.setString(2, Alergia);
			insert.setNString(3, Data_nascimento);
			insert.setString(4, Pessoa_CPF);
			insert.setString(5, Responsavel_Pessoa_CPF);
			
			return insert.execute();	
		} finally {
			paciente.fecharConexao();
			
		}
		
	}
	public boolean addResponsavelPaciente() throws SQLException {
		try {	
			Responsavel_Pessoa_CPF = CPF;
			PreparedStatement insert = paciente.getConexao().prepareStatement("INSERT INTO Responsavel(Pessoa_CPF) (SELECT CPF FROM Pessoa WHERE CPF = ?);");
			insert.setString(1, Responsavel_Pessoa_CPF);
			return insert.execute();	
		} finally {
			paciente.fecharConexao();
			Responsavel_Pessoa_CPF = null;
			
		}
	}
		
	
	public boolean visualizarPaciente(String Pessoa_CPF) throws SQLException{
		try {
			PreparedStatement select = paciente.getConexao().prepareStatement("SELECT * FROM Paciente WHERE Pessoa_CPF = ? ");
			select.setString(1, Pessoa_CPF);
			return select.execute();
		} finally {
			paciente.fecharConexao();
		}
	}
	
	public boolean excluirPaciente(String Pessoa_CPF) throws SQLException {
		try {
			PreparedStatement delete = paciente.getConexao().prepareStatement("DELETE FROM Paciente WHERE Pessoa_CPF = ?");
			delete.setString(1, Pessoa_CPF);
			return delete.execute();	
		} finally {
			paciente.fecharConexao();

		}
		
	}
	
	
	public String visualizarAgenda() {
		return null;}
	
	public String visualizarPaciente() {
		return null;
		
	}
	public String visualizarHistorico() {
		return null;}
	
	
	public String totalPaciente() {
		return null;}
	
	public String pacienteDia() {
		return null;}
	
	
	public String adcionarRegistro() {
		return null;}
	
	public String visualizarRegistro() {
		return null;}
	
	
	


	public static void main(String [] args ) throws SQLException{
		PacienteDAO teste = new PacienteDAO();
		teste.excluirPaciente("23412365433");
	
		

		
	
	}

}

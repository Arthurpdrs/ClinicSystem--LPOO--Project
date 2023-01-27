package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDAO extends FabricaConexao {
	FabricaConexao paciente = new FabricaConexao();
	public boolean addPaciente(String Tipo_sanguineo, String Alergia, String Data_nascimento) throws SQLException {
		try {
			PreparedStatement insert = paciente.getConexao().prepareStatement("INSERT INTO Paciente(Tipo_sanguineo, Alergia, Data_nascimento) VALUES(?, ?, ?)");
			insert.setString(1, Tipo_sanguineo);
			insert.setString(2, Alergia);
			insert.setString(3, Data_nascimento);
			return insert.execute();	
		} finally {
			paciente.fecharConexao();
		}
	}
	
	public boolean desmarcarConsulta(String Pessoa_CPF, String Medico_Funcionario_Pessoa_CPF)throws SQLException {
		try {
			PreparedStatement delete = paciente.getConexao().prepareStatement("DELETE FROM Consulta u WHERE u.Pessoa_CPF = ? AND u.Medico_Funcionario_Pessoa_CPF = ?");
			delete.setString(1, Pessoa_CPF);
			delete.setString(2, Medico_Funcionario_Pessoa_CPF);
			return delete.execute();	
		} finally {
			paciente.fecharConexao();

		}

	}
	
	public boolean marcarConsulta(String Data_consulta, Double Valor, String pago) throws SQLException{
		try {
			PreparedStatement insert = paciente.getConexao().prepareStatement("INSERT INTO consulta(Data_consulta, Valor, Pago) VALUES(?, ?, ?)");
			//insert.set(0, Data_consulta);
			insert.setDouble(2, Valor);
			insert.setString(0, pago);
			return insert.execute();	
		} finally {
			paciente.fecharConexao();
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
			PreparedStatement delete = paciente.getConexao().prepareStatement("DELETE FROM Pessoa WHERE Pessoa_CPF = ?");
			delete.setString(1, Pessoa_CPF);
			return delete.execute();	
		} finally {
			paciente.fecharConexao();

		}
		
	}
	
	
	

}

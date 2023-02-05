package core.services;

import java.sql.SQLException;

import javax.swing.JLabel;

import core.model.Paciente;
import dao.ConsultaDAO;
import dao.PacienteDAO;

public class EstatisticaService {
	
	public static boolean totalConsultasDia(JLabel label) throws SQLException {
		ConsultaDAO consultadao = new ConsultaDAO();
		String totalconsultasdia = consultadao.TotalConsultas();
		if(totalconsultasdia.equals(null)) {
			label.setText("0");
			return false;
		}
		label.setText(totalconsultasdia);
		return true;
	}
	
	public static boolean totalConsultasDiaMedico(JLabel label) throws SQLException {
		if (System.getProperty("cargo") == (null) || System.getProperty("cpf_logado") == (null)) {
			return false;
		} else {
			if (System.getProperty("cargo").equals("MEDICO")){
				return false;
			}
			String cpf = System.getProperty("cpf_logado");
			ConsultaDAO consultadao = new ConsultaDAO();
			String totalconsultasdia = consultadao.TotalConsultasMedico(cpf);
			if(totalconsultasdia.equals(null)) {
				totalconsultasdia = "0";
				return false;
			}
			label.setText(totalconsultasdia);
			return true;
		}
	}
	
	public static boolean totalPacientes(JLabel label) throws SQLException {
		Paciente paciente = new Paciente();
		PacienteDAO pacienteDAO = new PacienteDAO();
		if(pacienteDAO.totalPacientes().equals(null)) {
			label.setText("0");
			return false;
		}
		label.setText(pacienteDAO.totalPacientes());
		return true;
	}
	
	
	
	
	public static void main(String[] args) {
		
	}
	
}

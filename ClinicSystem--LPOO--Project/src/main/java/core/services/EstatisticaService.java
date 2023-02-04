package core.services;

import java.sql.SQLException;

import javax.swing.JLabel;

import dao.ConsultaDAO;

public class EstatisticaService {
	
	public static boolean totalConsultasDia(JLabel label) throws SQLException {
		ConsultaDAO consultadao = new ConsultaDAO();
		String totalconsultasdia = consultadao.TotalConsultas();
		if(totalconsultasdia.equals(null)) {
			totalconsultasdia = "0";
			return false;
		}
		label.setText(totalconsultasdia);
		return true;
	}
	public static void main(String[] args) {
		
	}
	
}

package core.services;

import core.model.Clinica;
import dao.ClinicaDAO;
import ui.JanelaDadosClinica;
import java.sql.SQLException;


public class ClinicaService extends JanelaDadosClinica {
	
	public Clinica retornarDadosDaClinica () throws SQLException {
		ClinicaDAO clinicaDAO = new ClinicaDAO();
		Clinica clinica = clinicaDAO.listarDadosClinica();
		return clinica;
	}
	
	public boolean atualizarDadosDaClinica (String nome, String email, String senha, String telefone, String endereco) throws SQLException {
		if (nome.isBlank() || email.isBlank() || senha.isBlank() || telefone.isBlank() || endereco.isBlank()) {
			return false;
		} else {
			Clinica Clinica = new Clinica(nome, email, senha, telefone, endereco);
			ClinicaDAO clinicaDAO = new ClinicaDAO();
			clinicaDAO.atualizarDados(Clinica);
			return true;
		}
	}
	
}

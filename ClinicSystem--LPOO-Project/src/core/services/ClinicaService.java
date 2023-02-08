package core.services;

import core.model.Clinica;
import dao.ClinicaDAO;
import java.sql.SQLException;


public class ClinicaService {
	
	public Clinica retornarDadosDaClinica () throws SQLException {
		ClinicaDAO clinicaDAO = new ClinicaDAO();
		Clinica clinica = clinicaDAO.listar();
		return clinica;
	}
	
	public static boolean atualizarDadosDaClinica (String nome, String email, String senha, String telefone, String endereco) throws SQLException {
		if (nome.isBlank() || senha.isBlank() || !(TextFieldService.validarEmail(email)) || !(TextFieldService.validarNumero(telefone)) || endereco.isBlank()) {
			return false;
		} else {
			Clinica Clinica = new Clinica(nome, email, senha, telefone, endereco);
			ClinicaDAO clinicaDAO = new ClinicaDAO();
			clinicaDAO.alterar(Clinica);
			return true;
		}
	}
	
	
}

package daoTestesJUnit;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;

import core.model.Clinica;
import dao.ClinicaDAO;

public class ClinicaDAOTestes {
	
	@Test
	public void alterarOk() {
		ClinicaDAO clinicaDAO = new ClinicaDAO();
		Clinica clinica = new Clinica();
		clinica.setNome("QQQQQQQQQQQQQQQQQQQQ");
		clinica.setEmail("naoresponda_clinicdataoutlaook.com");
		clinica.setSenha("clinicdata00_");
		clinica.setTelefone("81 90000-0000");
		clinica.setEndereco("Avenida Governador Agamenon Magalhães, 84, Santo Amaro, Recife, PE");
		try {
			boolean testeAlterarOk = clinicaDAO.alterar(clinica);
			assertTrue(testeAlterarOk);
			clinica.setNome("QQQQQQQQQQQQQQQQQQQQ");
			clinica.setEmail("naoresponda_clinicdataoutlaook.com");
			clinica.setSenha("clinicdata00_");
			clinica.setTelefone("81 99999-9999");
			clinica.setEndereco("Avenida Governador Agamenon Magalhães, 84, Santo Amaro, Recife, PE");
			clinicaDAO.alterar(clinica);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// falta os testes para quando lançar exceção
}

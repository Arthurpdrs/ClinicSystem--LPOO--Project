package daoTestesJUnit;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import org.junit.Test;
import dao.FuncionarioDAO;

public class FuncionarioDAOTestes {

	@Test
	public void testeInserirMedicoOk() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		try {
			boolean testeInserirOk = funcionarioDAO.inserir("gabriel", "MEDICO", "101010", "121212");
			assertTrue(testeInserirOk);
			funcionarioDAO.deletar("121212");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeInserirRecepcionistaOk() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		try {
			boolean testeInserirRecepcionistaOk = funcionarioDAO.inserir("maria", "RECEPCIONISTA", "131313", "010101");
			assertTrue(testeInserirRecepcionistaOk);
			funcionarioDAO.deletar("010101");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testeInserirAdminOk() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		try {
			boolean testeInserirAdminOk = funcionarioDAO.inserir("lucas", "ADMIN", "151515", "232323");
			assertTrue(testeInserirAdminOk);
			funcionarioDAO.deletar("232323");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeDeletarMedicoOk() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		try {
			funcionarioDAO.inserir("gabriel", "MEDICO", "101010", "121212");
			boolean testeDeletarMedicoOk = funcionarioDAO.deletar("121212");
			assertTrue(testeDeletarMedicoOk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeDeletarRecepcionistaOk() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		try {
			funcionarioDAO.inserir("maria", "RECEPCIONISTA", "131313", "010101");
			boolean testeDeletarRecepcionistaOk = funcionarioDAO.deletar("010101");
			assertTrue(testeDeletarRecepcionistaOk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testeDeletarAdminOk() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		try {
			funcionarioDAO.inserir("lucas", "ADMIN", "151515", "232323");
			boolean testeDeletarAdminOk = funcionarioDAO.deletar("232323");
			assertTrue(testeDeletarAdminOk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
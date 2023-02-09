package daoTestesJUnit;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Test;
import core.model.Recepcionista;
import dao.RecepcionistaDAO;

public class RecepcionistaDAOTestes {
	
	@Test
	public void testeInserirOk() {
		RecepcionistaDAO recepcionistaDAO = new RecepcionistaDAO();
		Recepcionista recepcionista = new Recepcionista();
		recepcionista.setCpf("454545");
		recepcionista.setNome("joana");
		recepcionista.setTelefone("81 96666-6666");
		recepcionista.setEmail("joana@gmail.com");
		recepcionista.setLogin("joanamaria");
		recepcionista.setSenha("33336666");
		try {
			boolean testeInserirOk = recepcionistaDAO.inserir(recepcionista);
			assertTrue(testeInserirOk);
			recepcionistaDAO.excluir(recepcionista);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeAlterarOk() {
		RecepcionistaDAO recepcionistaDAO = new RecepcionistaDAO();
		Recepcionista recepcionista = new Recepcionista();
		recepcionista.setCpf("787878");
		recepcionista.setNome("carla");
		recepcionista.setTelefone("81 93333-3333");
		recepcionista.setEmail("carla@gmail.com");
		recepcionista.setLogin("carla123");
		recepcionista.setSenha("11112222");
		try {
			recepcionistaDAO.inserir(recepcionista);
			recepcionista.setCpf("787878");
			recepcionista.setNome("carlafernanda");
			recepcionista.setTelefone("81 93333-3333");
			recepcionista.setEmail("carla@gmail.com");
			recepcionista.setLogin("carla123");
			recepcionista.setSenha("11112222");
			boolean testeAlterarOk = recepcionistaDAO.alterar(recepcionista);
			assertTrue(testeAlterarOk);
			recepcionistaDAO.excluir(recepcionista);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeExcluirOk() {
		RecepcionistaDAO recepcionistaDAO = new RecepcionistaDAO();
		Recepcionista recepcionista = new Recepcionista();
		recepcionista.setCpf("464646");
		recepcionista.setNome("julia");
		recepcionista.setTelefone("81 99999-9999");
		recepcionista.setEmail("julia@gmail.com");
		recepcionista.setLogin("julialima");
		recepcionista.setSenha("454545");
		try {
			recepcionistaDAO.inserir(recepcionista);
			boolean testeExcluirOk = recepcionistaDAO.excluir(recepcionista);
			assertTrue(testeExcluirOk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeInserirRecepcionistaDuplicada() {
		RecepcionistaDAO recepcionistaDAO = new RecepcionistaDAO();
		Recepcionista recepcionista = new Recepcionista();
		recepcionista.setCpf("454545");
		recepcionista.setNome("joana");
		recepcionista.setTelefone("81 96666-6666");
		recepcionista.setEmail("joana@gmail.com");
		recepcionista.setLogin("joanamaria");
		recepcionista.setSenha("33336666");
		try {
			recepcionistaDAO.inserir(recepcionista);
			recepcionista.setCpf("454545");
			recepcionista.setNome("joana");
			recepcionista.setTelefone("81 96666-6666");
			recepcionista.setEmail("joana@gmail.com");
			recepcionista.setLogin("joanamaria");
			recepcionista.setSenha("33336666");
			assertThrows(SQLIntegrityConstraintViolationException.class,
					() -> recepcionistaDAO.inserir(recepcionista));
			recepcionistaDAO.excluir(recepcionista);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

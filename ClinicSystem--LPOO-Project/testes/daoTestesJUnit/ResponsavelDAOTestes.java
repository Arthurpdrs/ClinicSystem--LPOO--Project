package daoTestesJUnit;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Test;

import core.model.Responsavel;
import dao.ResponsavelDAO;

public class ResponsavelDAOTestes {
	
	@Test
	public void testeInserirOk() {
		ResponsavelDAO responsavelDAO = new ResponsavelDAO();
		Responsavel responsavel = new Responsavel();
		responsavel.setCpf("898989");
		responsavel.setNome("lucas");
		responsavel.setTelefone("81 97777-7777");
		try {
			boolean testeInserirOk = responsavelDAO.inserir(responsavel);
			assertTrue(testeInserirOk);
			responsavelDAO.remover(responsavel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeAlterarOk() {
		ResponsavelDAO responsavelDAO = new ResponsavelDAO();
		Responsavel responsavel = new Responsavel();
		responsavel.setCpf("454545");
		responsavel.setNome("pedro");
		responsavel.setTelefone("81 93333-3333");
		try {
			responsavelDAO.inserir(responsavel);
			responsavel.setCpf("454545");
			responsavel.setNome("pedrovitor");
			responsavel.setTelefone("81 93333-3333");
			boolean testeAlterarOk = responsavelDAO.alterar(responsavel);
			assertTrue(testeAlterarOk);
			responsavelDAO.remover(responsavel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeRemoverOk() {
		ResponsavelDAO responsavelDAO = new ResponsavelDAO();
		Responsavel responsavel = new Responsavel();
		responsavel.setCpf("595959");
		responsavel.setNome("will");
		responsavel.setTelefone("81 90000-0000");
		try {
			responsavelDAO.inserir(responsavel);
			boolean testeRemoverOk = responsavelDAO.remover(responsavel);
			assertTrue(testeRemoverOk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeInserirResponsavelDuplicado() {
		ResponsavelDAO responsavelDAO = new ResponsavelDAO();
		Responsavel responsavel = new Responsavel();
		responsavel.setCpf("898989");
		responsavel.setNome("lucas");
		responsavel.setTelefone("81 97777-7777");
		try {
			responsavelDAO.inserir(responsavel);
			responsavel.setCpf("898989");
			responsavel.setNome("lucas");
			responsavel.setTelefone("81 97777-7777");
			assertThrows(SQLIntegrityConstraintViolationException.class,
					() -> responsavelDAO.inserir(responsavel));
			responsavelDAO.remover(responsavel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

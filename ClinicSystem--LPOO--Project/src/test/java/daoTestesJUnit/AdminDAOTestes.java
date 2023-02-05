package daoTestesJUnit;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;
import core.model.Admin;
import dao.AdminDAO;

public class AdminDAOTestes {
	
	@Test
	public void testeInserirOk() {
		AdminDAO adminDAO = new AdminDAO();
		Admin admin = new Admin();
		admin.setCpf("121212");
		admin.setNome("gabriel");
		admin.setTelefone("303030");
		admin.setEmail("gabriel@gmail.com");
		admin.setLogin("gabriel3000");
		admin.setSenha("010101");
		try {
			boolean testeInserirOk = adminDAO.inserir(admin);
			assertTrue(testeInserirOk);
			adminDAO.remover(admin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeAlterarOk() {
		AdminDAO adminDAO = new AdminDAO();
		Admin admin = new Admin();
		admin.setCpf("232323");
		admin.setNome("joao");
		admin.setTelefone("454545");
		admin.setEmail("joao@gmail.com");
		admin.setLogin("joao012");
		admin.setSenha("787878");
		try {
			adminDAO.inserir(admin);
			admin.setCpf("232323");
			admin.setNome("joao");
			admin.setTelefone("565656");
			admin.setEmail("joao@gmail.com");
			admin.setLogin("joao012");
			admin.setSenha("787878");
			boolean testeAlterarOk = adminDAO.alterar(admin);
			assertTrue(testeAlterarOk);
			adminDAO.remover(admin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeRemoverOk() {
		AdminDAO adminDAO = new AdminDAO();
		Admin admin = new Admin();
		admin.setCpf("585858");
		admin.setNome("julia");
		admin.setTelefone("898989");
		admin.setEmail("julia@gmail.com");
		admin.setLogin("julia5000");
		admin.setSenha("969696");
		try {
			adminDAO.inserir(admin);
			boolean testeRemoverOk = adminDAO.remover(admin);
			assertTrue(testeRemoverOk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// falta testes para quando lançar exceção
}

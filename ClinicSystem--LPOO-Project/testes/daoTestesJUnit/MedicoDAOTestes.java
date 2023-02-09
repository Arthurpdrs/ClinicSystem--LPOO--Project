package daoTestesJUnit;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Test;
import core.model.Medico;
import dao.MedicoDAO;

public class MedicoDAOTestes {
	
	@Test
	public void testeInserirOk() {
		MedicoDAO medicoDAO = new MedicoDAO();
		Medico medico = new Medico();
		medico.setCpf("010101");
		medico.setNome("joao");
		medico.setTelefone("81 98888-8888");
		medico.setEmail("joao@hotmail.com");
		medico.setLogin("joaomario");
		medico.setSenha("123321");
		medico.setCrm("456654");
		medico.setEspecialidade("OFTALMOLOGISTA");
		try {
			boolean testeInserirOk = medicoDAO.inserir(medico);
			assertTrue(testeInserirOk);
			medicoDAO.excluir(medico);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeAlterarOk() {
		MedicoDAO medicoDAO = new MedicoDAO();
		Medico medico = new Medico();
		medico.setCpf("020202");
		medico.setNome("luiza");
		medico.setTelefone("81 95555-5555");
		medico.setEmail("luiza@hotmail.com");
		medico.setLogin("luiza7000");
		medico.setSenha("262626");
		medico.setCrm("787878");
		medico.setEspecialidade("PEDIATRA");
		try {
			medicoDAO.inserir(medico);
			medico.setCpf("020202");
			medico.setNome("luiza");
			medico.setTelefone("81 97777-7777");
			medico.setEmail("luiza@hotmail.com");
			medico.setLogin("luiza7000");
			medico.setSenha("262626");
			medico.setCrm("787878");
			medico.setEspecialidade("PEDIATRA");
			boolean testeAlterarOk = medicoDAO.alterar(medico);
			assertTrue(testeAlterarOk);
			medicoDAO.excluir(medico);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeExcluirOk() {
		MedicoDAO medicoDAO = new MedicoDAO();
		Medico medico = new Medico();
		medico.setCpf("898989");
		medico.setNome("pablo");
		medico.setTelefone("81 91111-1111");
		medico.setEmail("pablo@hotmail.com");
		medico.setLogin("pablojr");
		medico.setSenha("919191");
		medico.setCrm("303030");
		medico.setEspecialidade("NEUROLOGISTA");
		try {
			medicoDAO.inserir(medico);
			boolean testeExcluirOk = medicoDAO.excluir(medico);
			assertTrue(testeExcluirOk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeInserirMedicoDuplicado() {
		MedicoDAO medicoDAO = new MedicoDAO();
		Medico medico = new Medico();
		medico.setCpf("010101");
		medico.setNome("joao");
		medico.setTelefone("81 98888-8888");
		medico.setEmail("joao@hotmail.com");
		medico.setLogin("joaomario");
		medico.setSenha("123321");
		medico.setCrm("456654");
		medico.setEspecialidade("OFTALMOLOGISTA");
		try {
			medicoDAO.inserir(medico);
			medico.setCpf("010101");
			medico.setNome("joao");
			medico.setTelefone("81 98888-8888");
			medico.setEmail("joao@hotmail.com");
			medico.setLogin("joaomario");
			medico.setSenha("123321");
			medico.setCrm("456654");
			medico.setEspecialidade("OFTALMOLOGISTA");
			assertThrows(SQLIntegrityConstraintViolationException.class,
					() -> medicoDAO.inserir(medico));
			medicoDAO.excluir(medico);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

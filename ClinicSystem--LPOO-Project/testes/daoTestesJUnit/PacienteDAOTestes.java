package daoTestesJUnit;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Test;

import core.model.Paciente;
import core.model.Responsavel;
import dao.PacienteDAO;

public class PacienteDAOTestes {
	
	@Test
	public void testeAdicionarOk() {
		PacienteDAO pacienteDAO = new PacienteDAO();
		Paciente paciente = new Paciente();
		Responsavel responsavel = new Responsavel();
		paciente.setNome("alderi");
		paciente.setTipoSanguineo("AB+");
		paciente.setAlergia("A tramal");
		paciente.setDataNascimento("18/03/1987");
		paciente.setCpf("121212");
		responsavel.setCpf("232323");
		responsavel.setNome("gabriel");
		responsavel.setTelefone("81 96666-6666");
		paciente.setResponsavel(responsavel);
		paciente.setEndereco("Rua Lagoa dos Gatos");
		paciente.setObservacao("Tontura");
		paciente.setTelefone("81 97777-7777");
		paciente.setEmail("alderi@gmail.com");
		try {
			boolean testeAdicionarOk = pacienteDAO.adicionar(paciente, responsavel);
			assertTrue(testeAdicionarOk);
			pacienteDAO.excluir(paciente.getCpf());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeAlterarOk() {
		PacienteDAO pacienteDAO = new PacienteDAO();
		Paciente paciente = new Paciente();
		Responsavel responsavel = new Responsavel();
		paciente.setNome("alderi");
		paciente.setTipoSanguineo("AB+");
		paciente.setAlergia("A tramal");
		paciente.setDataNascimento("18/03/1987");
		paciente.setCpf("121212");
		responsavel.setCpf("232323");
		responsavel.setNome("gabriel");
		responsavel.setTelefone("81 96666-6666");
		paciente.setResponsavel(responsavel);
		paciente.setEndereco("Rua Lagoa dos Gatos");
		paciente.setObservacao("Tontura");
		paciente.setTelefone("81 97777-7777");
		paciente.setEmail("alderi@gmail.com");
		try {
			pacienteDAO.adicionar(paciente, responsavel);
			paciente.setNome("alderi");
			paciente.setTipoSanguineo("O-");
			paciente.setAlergia("A tramal");
			paciente.setDataNascimento("18/03/1987");
			paciente.setCpf("121212");
			responsavel.setCpf("232323");
			responsavel.setNome("gabriel");
			responsavel.setTelefone("81 96666-6666");
			paciente.setResponsavel(responsavel);
			paciente.setEndereco("Rua Lagoa dos Gatos");
			paciente.setObservacao("Tontura");
			paciente.setTelefone("81 97777-7777");
			paciente.setEmail("alderi@gmail.com");
			boolean testeAlterarOk = pacienteDAO.alterar(paciente, responsavel);
			assertTrue(testeAlterarOk);
			pacienteDAO.excluir(paciente.getCpf());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeExcluirOk() {
		PacienteDAO pacienteDAO = new PacienteDAO();
		Paciente paciente = new Paciente();
		Responsavel responsavel = new Responsavel();
		paciente.setNome("alderi");
		paciente.setTipoSanguineo("AB+");
		paciente.setAlergia("A tramal");
		paciente.setDataNascimento("18/03/1987");
		paciente.setCpf("121212");
		responsavel.setCpf("232323");
		responsavel.setNome("gabriel");
		responsavel.setTelefone("81 96666-6666");
		paciente.setResponsavel(responsavel);
		paciente.setEndereco("Rua Lagoa dos Gatos");
		paciente.setObservacao("Tontura");
		paciente.setTelefone("81 97777-7777");
		paciente.setEmail("alderi@gmail.com");
		try {
			pacienteDAO.adicionar(paciente, responsavel);
			boolean testeExcluirOk = pacienteDAO.excluir(paciente.getCpf());
			assertTrue(testeExcluirOk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeAdicionarPacienteDuplicado() {
		PacienteDAO pacienteDAO = new PacienteDAO();
		Paciente paciente = new Paciente();
		Responsavel responsavel = new Responsavel();
		paciente.setNome("alderi");
		paciente.setTipoSanguineo("AB+");
		paciente.setAlergia("A tramal");
		paciente.setDataNascimento("18/03/1987");
		paciente.setCpf("121212");
		responsavel.setCpf("232323");
		responsavel.setNome("gabriel");
		responsavel.setTelefone("81 96666-6666");
		paciente.setResponsavel(responsavel);
		paciente.setEndereco("Rua Lagoa dos Gatos");
		paciente.setObservacao("Tontura");
		paciente.setTelefone("81 97777-7777");
		paciente.setEmail("alderi@gmail.com");
		try {
			pacienteDAO.adicionar(paciente, responsavel);
			paciente.setNome("alderi");
			paciente.setTipoSanguineo("AB+");
			paciente.setAlergia("A tramal");
			paciente.setDataNascimento("18/03/1987");
			paciente.setCpf("121212");
			responsavel.setCpf("232323");
			responsavel.setNome("gabriel");
			responsavel.setTelefone("81 96666-6666");
			paciente.setResponsavel(responsavel);
			paciente.setEndereco("Rua Lagoa dos Gatos");
			paciente.setObservacao("Tontura");
			paciente.setTelefone("81 97777-7777");
			paciente.setEmail("alderi@gmail.com");
			assertThrows(SQLIntegrityConstraintViolationException.class,
					() -> pacienteDAO.adicionar(paciente, responsavel));
			pacienteDAO.excluir(paciente.getCpf());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

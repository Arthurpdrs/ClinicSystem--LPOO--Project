package daoTestesJUnit;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;

import core.model.Consulta;
import core.model.Medico;
import core.model.Paciente;
import core.model.Prontuario;
import core.model.Responsavel;
import dao.ConsultaDAO;
import dao.ProntuarioDAO;

public class ProntuarioDAOTestes {
	
	@Test
	public void testeInserirOk() {
		ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
		Prontuario prontuario = new Prontuario();
		Paciente paciente = new Paciente();
		Medico medico = new Medico();
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
		prontuario.setPaciente(paciente);
		medico.setCpf("010101");
		medico.setNome("joao");
		medico.setTelefone("81 98888-8888");
		medico.setEmail("joao@hotmail.com");
		medico.setLogin("joaomario");
		medico.setSenha("123321");
		medico.setCrm("456654");
		medico.setEspecialidade("OFTALMOLOGISTA");
		prontuario.setMedico(medico);
		prontuario.setQueixa("Paciente não medicado");
		prontuario.setPrescricao("Medicação intravenosa");
		prontuario.setObservacao("Acompanhamento diário");
		prontuario.setData("15/02/23");
		try {
			boolean testeInserirOk = prontuarioDAO.inserir(prontuario);
			assertTrue(testeInserirOk);
			prontuarioDAO.remover(prontuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeRemoverOk() {
		ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
		Prontuario prontuario = new Prontuario();
		Paciente paciente = new Paciente();
		Medico medico = new Medico();
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
		prontuario.setPaciente(paciente);
		medico.setCpf("010101");
		medico.setNome("joao");
		medico.setTelefone("81 98888-8888");
		medico.setEmail("joao@hotmail.com");
		medico.setLogin("joaomario");
		medico.setSenha("123321");
		medico.setCrm("456654");
		medico.setEspecialidade("OFTALMOLOGISTA");
		prontuario.setMedico(medico);
		prontuario.setQueixa("Paciente não medicado");
		prontuario.setPrescricao("Medicação intravenosa");
		prontuario.setObservacao("Acompanhamento diário");
		prontuario.setData("15/02/23");
		try {
			prontuarioDAO.inserir(prontuario);
			boolean testeRemoverOk = prontuarioDAO.remover(prontuario);
			assertTrue(testeRemoverOk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// falta os testes para quando lançar exceção
}

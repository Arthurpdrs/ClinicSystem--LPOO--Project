package daoTestesJUnit;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;
import core.model.Consulta;
import core.model.Medico;
import core.model.Paciente;
import core.model.Responsavel;
import dao.ConsultaDAO;

public class ConsultaDAOTestes {
	
	@Test
	public void testeInserirOk() {
		ConsultaDAO consultaDAO = new ConsultaDAO();
		Consulta consulta = new Consulta();
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
		consulta.setPaciente(paciente);
		medico.setCpf("010101");
		medico.setNome("joao");
		medico.setTelefone("81 98888-8888");
		medico.setEmail("joao@hotmail.com");
		medico.setLogin("joaomario");
		medico.setSenha("123321");
		medico.setCrm("456654");
		medico.setEspecialidade("OFTALMOLOGISTA");
		consulta.setMedico(medico);
		consulta.setDataConsulta("08/02/23");
		consulta.setValor("200");
		consulta.setPago("PAGO");
		consulta.setHorario("09:50");
		try {
			boolean testeInserirOk = consultaDAO.inserir(consulta);
			assertTrue(testeInserirOk);
			consultaDAO.remover(consulta.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeAlterarOk() {
		ConsultaDAO consultaDAO = new ConsultaDAO();
		Consulta consulta = new Consulta();
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
		consulta.setPaciente(paciente);
		medico.setCpf("010101");
		medico.setNome("joao");
		medico.setTelefone("81 98888-8888");
		medico.setEmail("joao@hotmail.com");
		medico.setLogin("joaomario");
		medico.setSenha("123321");
		medico.setCrm("456654");
		medico.setEspecialidade("OFTALMOLOGISTA");
		consulta.setMedico(medico);
		consulta.setDataConsulta("08/02/23");
		consulta.setValor("200");
		consulta.setPago("PAGO");
		consulta.setHorario("09:50");
		try {
			consultaDAO.inserir(consulta);
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
			consulta.setPaciente(paciente);
			medico.setCpf("010101");
			medico.setNome("joao");
			medico.setTelefone("81 98888-8888");
			medico.setEmail("joao@hotmail.com");
			medico.setLogin("joaomario");
			medico.setSenha("123321");
			medico.setCrm("456654");
			medico.setEspecialidade("OFTALMOLOGISTA");
			consulta.setMedico(medico);
			consulta.setDataConsulta("08/02/23");
			consulta.setValor("200");
			consulta.setPago("PAGO");
			consulta.setHorario("10:00");
			boolean testeAlterarOk = consultaDAO.alterar(consulta);
			assertTrue(testeAlterarOk);
			consultaDAO.remover(consulta.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeRemoverOk() {
		ConsultaDAO consultaDAO = new ConsultaDAO();
		Consulta consulta = new Consulta();
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
		consulta.setPaciente(paciente);
		medico.setCpf("010101");
		medico.setNome("joao");
		medico.setTelefone("81 98888-8888");
		medico.setEmail("joao@hotmail.com");
		medico.setLogin("joaomario");
		medico.setSenha("123321");
		medico.setCrm("456654");
		medico.setEspecialidade("OFTALMOLOGISTA");
		consulta.setMedico(medico);
		consulta.setDataConsulta("08/02/23");
		consulta.setValor("200");
		consulta.setPago("PAGO");
		consulta.setHorario("09:50");
		try {
			consultaDAO.inserir(consulta);
			boolean testeRemoverOk = consultaDAO.remover(consulta.getId());
			assertTrue(testeRemoverOk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

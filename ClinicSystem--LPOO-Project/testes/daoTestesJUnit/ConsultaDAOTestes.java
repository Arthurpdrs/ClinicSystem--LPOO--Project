package daoTestesJUnit;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;

import core.model.Consulta;
import core.model.Medico;
import core.model.Paciente;
import dao.ConsultaDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;

public class ConsultaDAOTestes {
	
	@Test
	public void testeInserirOk() {
		ConsultaDAO consultaDAO = new ConsultaDAO();
		PacienteDAO pacienteDAO = new PacienteDAO();
		MedicoDAO medicoDAO = new MedicoDAO();
		Consulta consulta = new Consulta();
		Paciente paciente = new Paciente();
		Medico medico = new Medico();
		paciente.setCpf("363636");
		paciente.setNome("alice");
		paciente.setTelefone("81 94444-4444");
		paciente.setEmail("alice@gmail.com");
		paciente.setTipoSanguineo("A+");
		paciente.setAlergia("Alergia a Dipirona");
		paciente.setDataNascimento("14/02/2001");
		paciente.setResponsavel(responsavel); //inserir e retornar o cpf do responsavel
		paciente.setEndereco("Rua Boa Vista-Varadouro-32");
		paciente.setObservacao("Necessita urgência");
		
		medico.setCpf("121212");
		medico.setNome("gabriel");
		medico.setTelefone("81 95555-5555");
		medico.setEmail("gabriel@gmail.com");
		medico.setLogin("gabriel01");
		medico.setSenha("020202");
		medico.setCrm("123456");
		medico.setEspecialidade("CARDIOLOGISTA");
		
		consulta.setDataConsulta("05/02/2023");
		consulta.setValor("R$ 100,00");
		consulta.setPago("Pago");
		consulta.setHorario("10:30");
		
		// falta finalizar
	}

}

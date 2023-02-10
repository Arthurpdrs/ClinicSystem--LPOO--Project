package serviceTestesJUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import javax.swing.JTextField;
import org.junit.jupiter.api.Test;
import core.services.PacienteService;
import core.model.Paciente;


class PacienteServiceTestes {

	@Test
	public void testeRetornarPacienteFiltradoOK() {
		
		String cpf = "12312312300";
		PacienteService pacienteTeste = new PacienteService();		
		Paciente paciente = new Paciente();		

		try {
			assertEquals(paciente, pacienteTeste.retornarPacienteFiltrado(cpf));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testeRetornarPacienteFiltradoCPFIsBlank() {
		
		String cpf = "";
		PacienteService pacienteTeste = new PacienteService();		
		Paciente paciente = new Paciente();		

		try {
			assertNotEquals(paciente, pacienteTeste.retornarPacienteFiltrado(cpf));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testeRetornarPacienteFiltradoNull() {
		
		PacienteService pacienteTeste = new PacienteService();			

		assertThrows(NullPointerException.class,
				() -> pacienteTeste.retornarPacienteFiltrado(null));
		
	}
	
	
	@Test
	public void testeFiltrarPacienteOK() {
		
		JTextField textFieldCPF = new JTextField("12312312300");
		JTextField textFieldNome = new JTextField("Jose Maria");
		PacienteService paciente = new PacienteService();
		
		try {
			boolean filtro = paciente.filtrarPaciente(textFieldCPF, textFieldNome);
			assertTrue(filtro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeFiltrarPacienteCPFNOK() {
		JTextField textFieldCPF = new JTextField("A2312312300");
		JTextField textFieldNome = new JTextField("Jose Maria");
		PacienteService paciente = new PacienteService();
		
		try {
			boolean filtro = paciente.filtrarPaciente(textFieldCPF, textFieldNome);
			assertFalse(filtro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeFiltrarPacienteFieldIsBlank() {
		JTextField textFieldCPF = new JTextField("");
		JTextField textFieldNome = new JTextField("");
		PacienteService paciente = new PacienteService();
		
		try {
			boolean filtro = paciente.filtrarPaciente(textFieldCPF, textFieldNome);
			assertFalse(filtro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeCadastrarOk () {
		
		PacienteService paciente = new PacienteService();
		
		try {
			boolean cadastro = paciente.cadastrar("Jose Maria", "99 99999-9999", "jm@dominio.com", "12312312300", "O-", "Ovo", "01/01/2000", "Rua A", "Nenhuma", null);
			assertTrue(cadastro);
			paciente.deletarPaciente("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}
	
	
	@Test
	public void testeCadastrarSangueNOk () {
		
		PacienteService paciente = new PacienteService();
		
		try {
			boolean cadastro = paciente.cadastrar("Jose Maria", "99 99999-9999", "jm@dominio.com", "12312312300", "O Negativo", "Ovo", "01/01/2000", "Rua A", "Nenhuma", null);
			assertFalse(cadastro);
			paciente.deletarPaciente("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}
	
	
	@Test
	public void testeCadastrarDataNascNOk () {
		
		PacienteService paciente = new PacienteService();
		
		try {
			boolean cadastro = paciente.cadastrar("Jose Maria", "99 99999-9999", "jm@dominio.com", "12312312300", "O-", "Ovo", "01/01/00", "Rua A", "Nenhuma", null);
			assertFalse(cadastro);
			paciente.deletarPaciente("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}
	
	
	@Test
	public void testeCadastrarValoresIsBlank () {
		
		PacienteService paciente = new PacienteService();
		
		try {
			boolean cadastro = paciente.cadastrar("", "", "", "", "", "", "", "", "", null);
			assertFalse(cadastro);
			paciente.deletarPaciente("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}
	
	
	@Test
	public void testeCadastrarValoresNull () {
		
		PacienteService paciente = new PacienteService();
		
		assertThrows(NullPointerException.class,
				() -> paciente.cadastrar(null, null, null, null, null, null, null, null, null, null));
							
	}
	
	
	@Test
	public void testeDeletarPacienteOK() {
		
		PacienteService paciente = new PacienteService();
		
		try {
			paciente.cadastrar("Jose Maria", "99 99999-9999", "jm@dominio.com", "12312312300", "O-", "Ovo", "01/01/2000", "Rua A", "Nenhuma", null);
			boolean excluir = paciente.deletarPaciente("12312312300");
			assertTrue(excluir);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Test
	public void testeDeletarCPFIsBlank() {
		
		PacienteService paciente = new PacienteService();
		
		try {
			boolean excluir = paciente.deletarPaciente("");
			assertFalse(excluir);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeDeletarCPFNull() {
		
		PacienteService paciente = new PacienteService();
		
		assertThrows(NullPointerException.class,
				() -> paciente.deletarPaciente(null));
				
	}
	
	
	@Test
	public void testeAlterarOK() {
		
		PacienteService paciente = new PacienteService();

		try {
			paciente.cadastrar("Jose Maria", "99 99999-9999", "jm@dominio.com", "12312312300", "O-", "Ovo", "01/01/2000", "Rua A", "Nenhuma", null);
			boolean modificar = paciente.alterar("12312312300", "Jose Maria", "jm@dominio.com", "11 11111-1111", "Ovo", "O-", "01/01/2000", "Rua A", null, null, null, null);
			assertTrue(modificar);
			paciente.deletarPaciente("12312312300");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeAlterarValoresIsBlank() {
		
		PacienteService paciente = new PacienteService();
		
		try {
			assertFalse(paciente.alterar("", "", "", "", "", "", "", "", null, null, null, null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeAlterarValoresNull() {
		
		PacienteService paciente = new PacienteService();
		
		assertThrows(NullPointerException.class,
				() -> paciente.alterar(null, null, null, null, null, null, null, null, null, null, null, null));
	
	}

}




package serviceTestesJUnit;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.sql.SQLException;
import core.services.MedicoService;

class MedicoServiceTestes {

	@Test
	public void testeCadastrarOk () {
		
		MedicoService medico = new MedicoService();
		
		try {
			boolean cadastro = medico.cadastrar("Jose Maria", "99 99999-9999", "jm@dominio.com", "11111111100", "jmuser", "1111", "123456", "Cardiologista");
			assertTrue(cadastro);
			medico.excluir("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}
	
	
	@Test
	public void testeCadastrarValoresIsBlank() {
		
		MedicoService medico = new MedicoService();	
		
		try {
			boolean cadastro = medico.cadastrar("", "", "", "", "", "", "", "");
			assertFalse(cadastro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeCadastrarValoresNull() {
		
		MedicoService medico = new MedicoService();	

		assertThrows(NullPointerException.class,
				() -> medico.cadastrar(null, null, null, null, null, null, null, null));
				
	}
	
	
	@Test
	public void testeExcluirOK() {
		
		MedicoService medico = new MedicoService();	
		
		try {
			medico.cadastrar("Jose Maria", "99 99999-9999", "jm@dominio.com", "11111111100", "jmuser", "1111", "123456", "Cardiologista");
			boolean excluirOK = medico.excluir("11111111100");
			assertTrue(excluirOK);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeExcluirCPFIsBlank() {
		
		MedicoService medico = new MedicoService();	
		
		try {
			assertFalse(medico.excluir(""));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeExcluirCPFNull() {
		
		MedicoService medico = new MedicoService();	

		assertThrows(NullPointerException.class,
				() -> medico.excluir(null));
			
	}

	
	@Test
	public void testeAlterarOK() {
		
		MedicoService medico = new MedicoService();	

		try {
			medico.cadastrar("Jose Maria", "99 99999-9999", "jm@dominio.com", "11111111100", "jmuser", "1111", "123456", "Cardiologista");
			boolean modificar = medico.alterar("99999999900", "Maria Jose", "11 11111-1111", "mjuser", "mj@dominio.com", "1234", "654321", "Pediatra");
			assertTrue(modificar);
			medico.excluir("99999999900");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testeAlterarValoresIsBlank() {
		
		MedicoService medico = new MedicoService();	
		
		try {
			assertFalse(medico.alterar("", "",	"", "", "", "", "", ""));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeAlterarEspecialidadeLengthNOK() {
		
		MedicoService medico = new MedicoService();
		
		try {
			boolean modificar = medico.alterar("Jose Maria", "99 99999-9999", "jm@dominio.com", "11111111100", "jmuser", "1111", "123456", "Cardiologista, Pneumologista e Otorrinolaringologia");
			assertFalse(modificar);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeAlterarValoresNull() {
		
		MedicoService medico = new MedicoService();
		
		assertThrows(NullPointerException.class,
				() -> medico.alterar(null, null, null, null, null, null, null, null));
	}
	
	
}
package serviceTestesJUnit;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import core.services.RecepcionistaService;

class RecepcionistaServiceTestes {

	@Test
	public void testeCadastrarOk () {
		
		RecepcionistaService recepcionista = new RecepcionistaService();
		
		try {
			boolean cadastro = recepcionista.cadastrar("Maria Jose", "99 99999-9999", "mj@dominio.com", "11111111100", "mjuser", "1234");
			assertTrue(cadastro);
			recepcionista.excluir("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}
	
	
	@Test
	public void testeCadastrarIsBlank() {
		
		RecepcionistaService recepcionista = new RecepcionistaService();
		
		try {
			boolean cadastro = recepcionista.cadastrar("", "", "", "", "", "");
			assertFalse(cadastro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeCadastrarValoresNull() {
		
		RecepcionistaService recepcionista = new RecepcionistaService();	

		assertThrows(NullPointerException.class,
				() -> recepcionista.cadastrar(null, null, null, null, null, null));
				
	}
	
	
	@Test
	public void testeAlterarOK() {
		
		RecepcionistaService recepcionista = new RecepcionistaService();	

		try {
			recepcionista.cadastrar("Maria Jose", "99 99999-9999", "mj@dominio.com", "11111111100", "mjuser", "1234");
			boolean modificar = recepcionista.alterar("11111111100", "Jose Maria", "99 99999-9999", "jmuser", "jm@dominio.com", "1234");
			assertTrue(modificar);
			recepcionista.excluir("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testeAlterarIsBlank() {
		
		RecepcionistaService recepcionista = new RecepcionistaService();	
		
		try {
			assertFalse(recepcionista.alterar("", "",	"", "", "", ""));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeAlterarLengthNOK() {
		
		RecepcionistaService recepcionista = new RecepcionistaService();	
		
		try {
			boolean modificar = recepcionista.alterar("Maria Jose", "99 99999-9999", "mj@dominio.com", "11111111100", "mjuser", "123456789ABCDEFG");
			assertFalse(modificar);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeAlterarValorNull() {
		
		RecepcionistaService recepcionista = new RecepcionistaService();	
		
		assertThrows(NullPointerException.class,
				() -> recepcionista.alterar(null, null, null, null, null, null));
	}
	
	
}

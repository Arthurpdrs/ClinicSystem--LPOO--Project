package serviceTestesJUnit;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import core.model.Responsavel;
import core.services.ResponsavelService;


class ResponsavelServiceTestes {

	
	@Test
	public void testeCadastrarOk () {
		
		ResponsavelService responsavel = new ResponsavelService();
		
		try {
			Responsavel cadastro = responsavel.inserir("Jose Maria", "11111111100", "99 99999-9999");
			assertEquals(responsavel, cadastro);
			responsavel.deletar("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}
	
	
	@Test
	public void testeCadastrarIsBlank() {
		
		ResponsavelService responsavel = new ResponsavelService();
		
		try {
			Responsavel cadastro = responsavel.inserir("", "", "");
			assertNotEquals(responsavel, cadastro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeCadastrarValoresNull() {
		
		ResponsavelService responsavel = new ResponsavelService();

		assertThrows(NullPointerException.class,
				() -> responsavel.inserir(null, null, null));
				
	}
	
	
	@Test
	public void testeExcluirOK() {
		
		ResponsavelService responsavel = new ResponsavelService();
		
		try {
			responsavel.inserir("Jose Maria", "11111111100", "99 99999-9999");
			boolean excluir = responsavel.deletar("11111111100");
			assertTrue(excluir);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeExcluirCPFIsBlank() {
		
		ResponsavelService responsavel = new ResponsavelService();
		
		assertFalse(responsavel.deletar(""));
	}
	
	
	@Test
	public void testeExcluirCPFNull() {
		
		ResponsavelService responsavel = new ResponsavelService();

		assertThrows(NullPointerException.class,
				() -> responsavel.deletar(null));
			
	}
}

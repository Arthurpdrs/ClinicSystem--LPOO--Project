package serviceTestesJUnit;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import core.model.Funcionario;
import core.services.FuncionarioService;
import dao.FuncionarioDAO;

public class FuncionarioServiceTestes {

	@Test
	public void testeLoginOK() throws SQLException {
		
		FuncionarioService funcionario = new FuncionarioService();	
		
		funcionario.inserir("USER", "1234", "MEDICO", "11111111100");
		
		boolean loginOK = funcionario.fazerLogin("USER", "1234");
		assertTrue(loginOK);
		
		funcionario.excluir("11111111100");
				
	}
	
	
	@Test
	public void testeUserError() throws SQLException {
		
		FuncionarioService funcionario = new FuncionarioService();	
		
		funcionario.inserir("USER", "1234", "MEDICO", "11111111100");
		
		boolean loginOK = funcionario.fazerLogin("USUARIO", "1234");
		assertFalse(loginOK);
		
		funcionario.excluir("11111111100");
		
	}

	
	@Test
	public void testeSenhaError() throws SQLException {
		
		FuncionarioService funcionario = new FuncionarioService();	
		
		funcionario.inserir("USER", "1234", "MEDICO", "11111111100");
		
		boolean loginOK = funcionario.fazerLogin("USER", "4321");
		assertFalse(loginOK);
		
		funcionario.excluir("11111111100");
		
	}

	@Test
	public void testeNullError() throws SQLException {
		
		FuncionarioService funcionario = new FuncionarioService();	
		
		funcionario.inserir("USER", "1234", "", "11111111100");
		
		boolean loginOK = funcionario.fazerLogin("USUARIO", "1234");
		assertFalse(loginOK);
		
		funcionario.excluir("11111111100");
		
	}
	

}


package serviceTestesJUnit;

import static org.junit.Assert.*;
import java.sql.SQLException;

import javax.swing.JTable;

import org.junit.Test;
import core.services.FuncionarioService;

public class FuncionarioServiceTestes {
	

	@Test
	public void testeLoginOK() {
		
		FuncionarioService funcionario = new FuncionarioService();	
		
		try {
			funcionario.inserir("USER", "1234", "MEDICO", "11111111100");
			boolean login = funcionario.fazerLogin("USER", "1234");
			assertTrue(login);
			funcionario.excluir("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeLoginUserNOK() {
		
		FuncionarioService funcionario = new FuncionarioService();	
		
		try {
			funcionario.inserir("USER", "1234", "MEDICO", "11111111100");
			boolean login = funcionario.fazerLogin("USUARIO", "1234");
			assertFalse(login);
			funcionario.excluir("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	
	@Test
	public void testeLoginSenhaNOK() {
		
		FuncionarioService funcionario = new FuncionarioService();	
		
		try {
			funcionario.inserir("USER", "1234", "MEDICO", "11111111100");
			boolean login = funcionario.fazerLogin("USER", "4321");
			assertFalse(login);
			funcionario.excluir("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void testeLoginUserIsBlank() {
		
		FuncionarioService funcionario = new FuncionarioService();	
		
		try {
			boolean login = funcionario.fazerLogin("", "11111111100");
			assertFalse(login);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeLoginSenhaIsBlank() {
		
		FuncionarioService funcionario = new FuncionarioService();	
		
		try {
			boolean login = funcionario.fazerLogin("USER", "");
			assertFalse(login);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeLoginValoresNull() {
		
		FuncionarioService funcionario = new FuncionarioService();	
		
		assertThrows(NullPointerException.class,
				() -> funcionario.inserir( null, null, null, null));
							
	}
		
	
	@Test
	public void testeInserirOk () {
		
		FuncionarioService funcionario = new FuncionarioService();
		
		try {
			boolean cadastro = funcionario.inserir("USER", "1234", "MEDICO", "11111111100");
			assertTrue(cadastro);
			funcionario.excluir("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}
	
	
	@Test
	public void testeInserirIsBlank() {
		
		FuncionarioService funcionario = new FuncionarioService();	
		
		try {
			boolean cadastro = funcionario.inserir("", "", "", "");
			assertFalse(cadastro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeInserirValoresNull() {
		
		FuncionarioService funcionario = new FuncionarioService ();

		assertThrows(NullPointerException.class,
				() -> funcionario.inserir(null, null, null, null));
				
	}
	
	
	@Test
	public void testeExcluirOK() {
		
		FuncionarioService funcionario = new FuncionarioService ();
		
		try {
			funcionario.inserir("USER", "1234", "MEDICO", "11111111100");
			boolean excluirOK = funcionario.excluir("11111111100");
			assertTrue(excluirOK);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeExcluirCPFIsBlank() {
		
		FuncionarioService funcionario = new FuncionarioService ();
		
		try{
			assertFalse(funcionario.excluir(""));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeExcluirCPFNull() {
		
		FuncionarioService funcionario = new FuncionarioService ();

		assertThrows(NullPointerException.class,
				() -> funcionario.excluir(null));
			
	}

}
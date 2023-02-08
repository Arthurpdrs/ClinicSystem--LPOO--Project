package serviceTestesJUnit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.Assert;
import org.junit.Test;

import core.model.Funcionario;
import core.model.Medico;
import core.model.Recepcionista;
import core.services.FuncionarioService;
import dao.FuncionarioDAO;
import dao.MedicoDAO;
import dao.RecepcionistaDAO;

public class FuncionarioServiceTestes {

	

	@Test
	public void testeLoginOK() {
		
		FuncionarioService funcionario = new FuncionarioService();	
		
		try {
			funcionario.inserir("USER", "1234", "MEDICO", "11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		boolean login = false;
		try {
			login = funcionario.fazerLogin("USER", "1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(login);
		
		try {
			funcionario.excluir("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
	
	
	@Test
	public void testeLoginUserError() {
		
		FuncionarioService funcionario = new FuncionarioService();	
		
		try {
			funcionario.inserir("USER", "1234", "MEDICO", "11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		boolean login = true;
		try {
			login = funcionario.fazerLogin("USUARIO", "1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertFalse(login);
		
		try {
			funcionario.excluir("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	@Test
	public void testeLoginSenhaError() {
		
		FuncionarioService funcionario = new FuncionarioService();	
		
		try {
			funcionario.inserir("USER", "1234", "MEDICO", "11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		boolean login = true;
		try {
			login = funcionario.fazerLogin("USER", "4321");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertFalse(login);
		
		try {
			funcionario.excluir("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

//	@Test //implementar a lógica correta p/ testar exceção SQL
//	public void testeLoginValoresNull() {
//		
//		FuncionarioService funcionario = new FuncionarioService();	
//		
//		funcionario.inserir( null, null, null, null);
//		
//		assertThrows ();
//							
//	}
	
	
	@Test
	public void testeInserirOk () {
		
		FuncionarioService funcionario = new FuncionarioService();
		
		boolean inserirOK = false;
		try {
			inserirOK = funcionario.inserir("USER", "1234", "MEDICO", "11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(inserirOK);
		
		try {
			funcionario.excluir("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
							
	}
	
	
//	@Test   //implementar a lógica correta p/ testar exceção SQL
//	public void testeInserirNOK() {
//		
//		FuncionarioService funcionario = new FuncionarioService ();
//		
//		
//	}
	
	
	@Test
	public void testeExcluirOK() {
		
		FuncionarioService funcionario = new FuncionarioService ();
		
		boolean excluirOK = false;
		try {
			funcionario.inserir("USER", "1234", "MEDICO", "11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			excluirOK = funcionario.excluir("11111111100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(excluirOK);
	
	}
	
		
}




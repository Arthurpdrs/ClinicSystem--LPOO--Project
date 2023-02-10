package serviceTestesJUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import core.model.Consulta;
import core.services.ConsultaService;
import dao.FabricaConexao;

class ConsultaServiceTestes {

	@Test
	public void testeInserirOk() {
		
		ConsultaService consultaTeste = new ConsultaService();
		
		try {
			boolean marcacao = consultaTeste.inserir("Jose Maria", "99 99999-9999", "12312312300", "jm@dominio.com", "09:00", "R$20,00", "Nenhuma", "pago", "00011122299", "32132132100", "01/01/2020");
			assertTrue(marcacao);
			
			FabricaConexao consultaServiceTestes = new FabricaConexao();
			
			Consulta consulta = new Consulta();
			String sql = "DELETE FROM Consulta WHERE Paciente_CPF = ?";
			try {
				PreparedStatement stmt = consultaServiceTestes.getConexao().prepareStatement(sql);
				stmt.setString(1, consulta.getPaciente().getCpf());
				stmt.execute();
				consultaServiceTestes.fecharConexao();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}

	
	@Test
	public void testeInserirHorarioNOk() {
		
		ConsultaService consulta = new ConsultaService();
		
		try {
			boolean marcacao = consulta.inserir("Jose Maria", "99 99999-9999", "12312312300", "jm@dominio.com", "09hs", "R$20,00", "Nenhuma", "pago", "00011122299", "32132132100", "01/01/2020");
			assertFalse(marcacao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeInserirDataNOk() {
		
		ConsultaService consulta = new ConsultaService();
		
		try {
			boolean marcacao = consulta.inserir("Jose Maria", "99 99999-9999", "12312312300", "jm@dominio.com", "09:00", "R$20,00", "Nenhuma", "pago", "00011122299", "32132132100", "01/01/20");
			assertFalse(marcacao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeInserirValoresIsBlank() {
		
		ConsultaService consulta = new ConsultaService();
		
		try {
			boolean marcacao = consulta.inserir("", "", "", "", "", "", "", "", "", "", "");
			assertFalse(marcacao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeInserirValoresNull() {
		
		ConsultaService consulta = new ConsultaService();
		
		assertThrows(NullPointerException.class,
				() -> consulta.inserir(null, null, null, null, null, null, null, null, null, null, null));
				
	}
	
	
	@Test
	public void testeAlterarOK() {
		
		ConsultaService consulta = new ConsultaService();

		try {
			consulta.inserir("Jose Maria", "99 99999-9999", "12312312300", "jm@dominio.com", "09:00", "R$20,00", "Nenhuma", "pago", "00011122299", "32132132100", "01/01/2020");
			boolean modificar = consulta.alterar("01/02/2020", "R$20,00", "pago", "09:00", 01);
			assertTrue(modificar);
			consulta.remover(01);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeAlterarHorarioNOK() {
		
		ConsultaService consulta = new ConsultaService();

		try {
			boolean modificar = consulta.alterar("01/02/2020", "R$20,00", "pago", "09hs", 01);
			assertFalse(modificar);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeAlterarDataNOK() {
		
		ConsultaService consulta = new ConsultaService();

		try {
			boolean modificar = consulta.alterar("01/02/20", "R$20,00", "pago", "09:00", 01);
			assertFalse(modificar);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testeAlterarIdNOK() {
		
		ConsultaService consulta = new ConsultaService();

		try {
			boolean modificar = consulta.alterar("01/02/20", "R$20,00", "pago", "09:00", 0);
			assertFalse(modificar);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testeAlterarValoresNull() {
		
		ConsultaService consulta = new ConsultaService();
		
		assertThrows(NullPointerException.class,
				() -> consulta.alterar(null, null, null, null, 01));
	
	}
	
	
	@Test
	public void testeRemoverOK() {
		
		ConsultaService consulta = new ConsultaService();
		
		try {
			boolean excluir = consulta.remover(1);
			assertTrue(excluir);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testeRemoverNOK() {
		
		ConsultaService consulta = new ConsultaService();
		
		try {
			boolean excluir = consulta.remover(0);
			assertFalse(excluir);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
	

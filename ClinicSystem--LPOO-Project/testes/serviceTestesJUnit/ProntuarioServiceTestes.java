package serviceTestesJUnit;

import static org.junit.Assert.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import core.model.Prontuario;
import core.services.ProntuarioService;
import dao.FabricaConexao;

class ProntuarioServiceTestes {

	@Test
	public void testeCadastrarOk () {
		
		ProntuarioService prontuarioTeste = new ProntuarioService();
		
				
		try {
			boolean cadastro = prontuarioTeste.inserir("dor", "OBSMedica", "01/01/2023", "prescricao", "11122233300", "Carlos", "Jose Maria", "Cardiologista");
			assertTrue(cadastro);
			
			//excluíndo o registro inserido no banco de dados 
			FabricaConexao prontuarioServiceTestes = new FabricaConexao();
			Prontuario prontuario = new Prontuario();
			String sql = "DELETE FROM Prontuario WHERE Paciente_CPF=?";
			try {
				PreparedStatement stmt = prontuarioServiceTestes.getConexao().prepareStatement(sql);
				stmt.setString(1, prontuario.getPaciente().getCpf());
				stmt.execute();
				prontuarioServiceTestes.fecharConexao();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}
	
	@Test
	public void testeCadastrarValoresIsBlank () {
		
		ProntuarioService prontuarioTeste = new ProntuarioService();
				
		try {
			boolean cadastro = prontuarioTeste.inserir("", "", "", "", "", "", "", "");
			assertFalse(cadastro);
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}
	
	@Test
	public void testeCadastrarValoresNull () {
		
		ProntuarioService prontuarioTeste = new ProntuarioService();
		
		assertThrows(NullPointerException.class,
				() -> prontuarioTeste.inserir(null, null, null, null, null, null, null, null));
	}
	
}

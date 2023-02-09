package serviceTestesJUnit;

import static org.junit.Assert.assertTrue;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import core.services.ProntuarioService;
import dao.ProntuarioDAO;

class ProntuarioServiceTestes {

	@Test
	public void testeCadastrarOk () {
		
		ProntuarioService prontuario = new ProntuarioService();
		ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
				
		try {
			boolean cadastro = prontuario.inserir("dor", "OBSMedica", "01/01/2023", "prescricao", "11122233300", "Carlos", "Jose Maria", "Cardiologista");
			assertTrue(cadastro);
//			prontuarioDAO.remover(prontuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}
}

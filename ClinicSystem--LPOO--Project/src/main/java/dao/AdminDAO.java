package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDAO extends FabricaConexao {
	
	FabricaConexao admin = new FabricaConexao();
	
	public boolean verificarLoginAdmin(String senha, String login) throws SQLException{
		try {
			PreparedStatement select = admin.getConexao().prepareStatement("SELECT Login, Senha FROM Administrador u WHERE u.Login = ? AND u.Senha = ?");
			select.setString(1, login);
			select.setNString(2, senha);
			return select.execute();
		} finally {
			admin.fecharConexao();
		}
	
			
	}
	

}



package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import core.model.Admin;

public class AdminDAO extends FabricaConexao {
	
	FabricaConexao adminDao = new FabricaConexao();
	
	public boolean verificarLoginAdmin(Admin admin) throws SQLException {
		String sql = "SELECT Login, Senha FROM Administrador u WHERE u.Login = ? AND u.Senha = ?";
		try {
			PreparedStatement select = adminDao.getConexao().prepareStatement(sql);
			select.setString(1, admin.getLogin());
			select.setString(2, admin.getSenha());
			return select.execute();
		} catch (SQLException e) {
			System.out.println("Não foi possivel verifacar o Login e a senha");
			return false;
		} finally {
			adminDao.fecharConexao();
		}

			
	}
	

}



package core.services;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import core.model.Funcionario;
import core.model.Medico;
import core.model.Paciente;
import core.model.Recepcionista;
import dao.FuncionarioDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import dao.RecepcionistaDAO;

public class FuncionarioService {
	
	public boolean fazerLogin(String login, String senha) throws SQLException {
		if (login.isBlank() || senha.isBlank()) {
			return false;
		} else {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			Funcionario funcionario = funcionarioDAO.verificar(login);
			if (funcionario.getSenha() == null) {
				return false;
			} else {
				if (login.equals(funcionario.getLogin()) && senha.equals(funcionario.getSenha())) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
	
	public boolean visualizarProfissionais(JTable jtable) throws SQLException {
		DefaultTableModel model = (DefaultTableModel) jtable.getModel();
		
		RecepcionistaDAO recepcionistaDAO = new RecepcionistaDAO();
		List<Recepcionista> recepcionistas = recepcionistaDAO.listar();
		
		MedicoDAO medicoDAO = new MedicoDAO();
		List<Medico> medicos = medicoDAO.listar();
		
		
		if ((recepcionistas.size() > 0) || (medicos.size() > 0)) {
	        model.setNumRows(0);
	        if (recepcionistas.size() > 0) {
				for (Recepcionista recepcionista : recepcionistas) {
						model.addRow(new Object[] {
								recepcionista.getNome(),
								recepcionista.getLogin(),
								recepcionista.getSenha(),
								recepcionista.getCpf(),
								recepcionista.getEmail(),
								recepcionista.getTelefone(),
								"RECEPCIONISTA",
								"",
								""
						});
					}
				}
	        
	        
	        if (medicos.size() > 0) {
				for (Medico medico: medicos) {
						model.addRow(new Object[] {
								medico.getNome(),
								medico.getLogin(),
								medico.getSenha(),
								medico.getCpf(),
								medico.getEmail(),
								medico.getTelefone(),
								"MEDICO",
								medico.getEspecialidade(),
								medico.getCrm()
						});
					}
				}
	        jtable.setModel(model);
			return true;
		}
		return false;
}
	
	public boolean inserir(String usuario, String senha, String cargo, String cpf) throws SQLException {
		if (usuario.isBlank() || senha.isBlank() || cargo.isBlank() || cpf.isBlank()) {
			return false;
		} else {
			String usuarioLower = usuario.toLowerCase().trim();
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.inserir(usuarioLower, cargo, senha, cpf);
			return true;
		}
	}
	
	public boolean excluir(String cpf) throws SQLException {
		if (cpf.isBlank()) {
			return false;
		} else {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.deletar(cpf);
			return true;
		}
	}
}

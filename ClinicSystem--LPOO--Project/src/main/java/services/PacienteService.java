package services;

import java.util.Date;

import model.Endereco;
import model.Paciente;

public class PacienteService {
	
	public void cadastrar(String nome, String telefone, String email, String cpf,
			String tipoSanguineo, String alergia, Date dataNascimento, Endereco endereco) {
		
		Paciente paciente = new Paciente(nome, telefone, email, cpf, tipoSanguineo, alergia, dataNascimento, endereco);
		//Chamar metodo de PacienteDAO
	}

}

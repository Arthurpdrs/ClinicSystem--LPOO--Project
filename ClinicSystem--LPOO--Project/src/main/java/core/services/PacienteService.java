package core.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.model.Endereco;
import core.model.Paciente;

public class PacienteService {
	
	public void cadastrar(String nome, String telefone, String email, String cpf,
			String tipoSanguineo, String alergia, Date dataNascimento, Endereco endereco) {
		
		Paciente paciente = new Paciente(nome, telefone, email, cpf, tipoSanguineo, alergia, dataNascimento, endereco);
		
		if(verificarDadosObrigatorios(paciente)) {
			//Chamar metodo de PacienteDAO
		}
			
	}
	
	private boolean verificarDadosObrigatorios(Paciente paciente) {
		
		List<String> dadosObrigatorios = new ArrayList<String>();
		dadosObrigatorios.add(paciente.getNome());
		dadosObrigatorios.add(paciente.getTelefone());
		dadosObrigatorios.add(paciente.getEmail());
		dadosObrigatorios.add(paciente.getCpf());
		
		for(String dado : dadosObrigatorios) {
			
			if(dado.isBlank()) {
				return false;
			}
		}
		
		return true;
	}
}

package core.services;

public class EnderecoService {
	
	public static String montarEndereco(String logradouro, String numero, String bairro, String cidade, String cep) {
		
		String endereco = logradouro + " " + numero + " " + bairro + " " + cidade + " " + cep;
		return endereco;
	}

}

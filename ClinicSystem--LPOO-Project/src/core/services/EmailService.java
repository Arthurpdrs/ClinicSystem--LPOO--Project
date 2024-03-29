package core.services;

import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;

import javax.mail.MessagingException;

import javax.mail.Multipart;

import javax.mail.PasswordAuthentication;

import javax.mail.Session;

import javax.mail.Transport;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeBodyPart;

import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeMultipart;

import core.model.Clinica;

public class EmailService {

		public static boolean enviarEmail(String tipoDoEmail, String emailDoPaciente, String nomeDoPaciente, String dataDaConsulta, String horarioDaConsulta, String profissionalDaConsulta) throws SQLException {

	        Properties propriedades = definirPropriedadesDoEmail();
	
	        ClinicaService clinicaService = new ClinicaService();
			Clinica clinica = clinicaService.retornarDadosDaClinica ();
			final String emailClinica = clinica.getEmail();
			final String senhaClinica = clinica.getSenha();
			String enderecoClinica = clinica.getEndereco();
			String telefoneClinica = clinica.getTelefone();
			String nomeClinica = clinica.getNome();
			
	        Session conexao = iniciarSessaoDoEmail(propriedades, emailClinica, senhaClinica);
	
	        
	
	        try {
	
	            Message mensagem = new MimeMessage(conexao);
	
	            
	
	            mensagem.setFrom(new InternetAddress(emailClinica));
	
	            
	
	            mensagem.setRecipients(Message.RecipientType.TO,
	
	                    InternetAddress.parse(emailDoPaciente));
	
	            
	
	            mensagem.setSubject("Aviso - " + nomeClinica);
	
	            MimeBodyPart mensagemHtml = new MimeBodyPart();
	
	            
	
	            String lembrete = "Estamos passando para te lembrar da sua consulta ;)";
	
	            String cancelamento = "Infelizmente a sua consulta foi cancelada :(";
	
	            String conteudo = "";
	
	            
	
	            if (tipoDoEmail == "cancelamento") {
	
	            	conteudo = cancelamento;
	
	            } else if (tipoDoEmail == "lembrete") {
	
	            	conteudo = lembrete;
	
	            } else {
	
	            	return false;
	
	            }
	
	            
	
	            String codigo = ""
	
	            		+ "<body>\r\n"
	
	            		+ "<div style=\"height:200px; overflow:auto; padding: 12px;\">\r\n"
	
	            		+ "<div style=\"text-align: center;\">\r\n"
	
	            		+ "<h1>Olá, "
	
	            		+ nomeDoPaciente
	
	            		+ "</h1>\r\n"
	
	            		+ "<h2 style=\"font-size: 20px;\">"
	
	            		+ conteudo
	
	            		+ "</h2>\r\n"
	
	            		+ "<div style=\"border: 1px solid silver;padding: 10px;border-radius: 10px;\">\r\n"
	
	            		+ "<div style=\"border-bottom: 1px solid silver;\">\r\n"
	
	            		+ "\r\n"
	
	            		+ "<div style=\"text-align: left;padding: 15px;margin-left: 50px;max-width: 392px;word-break: break-word;\">Endereço:<div style=\"display: inline;font-weight: bold;margin-left: 5px;\">"
	            		+ enderecoClinica
	            		+ "</div></div></div>\r\n"
	
	            		+ "<div style=\"border-bottom: 1px solid silver;\"><div style=\"text-align: left;padding: 15px;margin-left: 50px;max-width: 392px;word-break: break-word;\"> Horário: <div style=\"display: inline;font-weight: bold;margin-left: 5px;\">"
	
	            		+ horarioDaConsulta
	
	            		+ "</div></div>\r\n"
	
	            		+ "\r\n"
	
	            		+ "</div>\r\n"
	
	            		+ "<div style=\"\"><div style=\"text-align: left;padding: 15px;margin-left: 50px;max-width: 392px;word-break: break-word;\">Profissional:<div style=\"display: inline;font-weight: bold;margin-left: 5px;\">"
	
	            		+ profissionalDaConsulta
	
	            		+ "</div></div>\r\n"
	
	            		+ "\r\n"
	
	            		+ "</div>\r\n"
	
	            		+ "</div>\r\n"
	
	            		+ "\r\n"
	
	            		+ "\r\n"
	
	            		+ "<div style=\"font-size: 15px;color: #4b69a8;margin-top: 20px;\">Número (Contato): "
	            		+ telefoneClinica
	            		+ "</div><div style=\"font-size: 15px;color: #4b69a8;margin-top: 20px;\">E-mail: "
	            		+ emailClinica
	            		+ "</div>\r\n"
	
	            		+ "\r\n"
	
	            		+ "<p>Em caso de dúvidas ou reagendamento entre em contato conosco pelos nossos canais de comunicação.</p>\r\n"
	
	            		+ "<p>Nós agradecemos pela compreensão :)</p>\r\n"
	
	            		+ "<p>Equipe "
	            		+ nomeClinica
	            		+ "</p><p style=\"font-size: 12px;margin-top: 50px;color: silver;\">E-MAIL ENVIADO AUTOMATICAMENTE. POR FAVOR, NÃO RESPONDER</p></div>\r\n"
	
	            		+ "</body>";
	
	            mensagemHtml.setContent(codigo, "text/html; charset=UTF-8");
	
	            Multipart multipart = new MimeMultipart();
	
	            multipart.addBodyPart(mensagemHtml);
	
	            mensagem.setContent(multipart);
	
	            Transport.send(mensagem);
	
	            
	
	            return true;

        } catch (MessagingException e) {

            return false;

        }

	}

	private static Session iniciarSessaoDoEmail(Properties propriedades, final String email, final String senha) {

		Session conexao = Session.getInstance(propriedades,

                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(email, senha);

                    }

                });

		return conexao;

	}

	private static Properties definirPropriedadesDoEmail() {

		Properties propriedades = new Properties();

        propriedades.put("mail.smtp.auth", "true");

    	propriedades.put("mail.smtp.socketFactory.fallback", "false");

 	    propriedades.put("mail.smtp.starttls.enable", "true");

    	propriedades.put("mail.smtp.ssl.trust", "smtp.office365.com");

   	    propriedades.put("mail.smtp.host", "smtp.office365.com");

    	propriedades.put("mail.smtp.port", "587");

    	propriedades.put("mail.smtp.ssl.protocols", "TLSv1.2");

		return propriedades;

	}

	

    public static void main(String[] args) {

    	try {
			enviarEmail("cancelamento", "paos@discente.ifpe.edu.br", "Paulo", "25/01/2023", "10:00", "Dr. Josevaldo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	try {
			enviarEmail("lembrete", "paos@discente.ifpe.edu.br", "Paulo", "25/01/2023", "10:00", "Dr. Josevaldo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

}

package services;

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

public class Email {
	
	public static boolean enviarEmail(String tipoDoEmail, String emailDoPaciente, String nomeDoPaciente, String dataDaConsulta, String horarioDaConsulta, String profissionalDaConsulta) {
		//Propriedades
        Properties propriedades = new Properties();
        propriedades.put("mail.smtp.auth", "true");
        propriedades.put("mail.smtp.socketFactory.fallback", "false");
        propriedades.put("mail.smtp.starttls.enable", "true");
        propriedades.put("mail.smtp.ssl.trust", "smtp.office365.com");
        propriedades.put("mail.smtp.host", "smtp.office365.com");
        propriedades.put("mail.smtp.port", "587");
        propriedades.put("mail.smtp.ssl.protocols", "TLSv1.2");
        
        
        //Inicia sessão
        Session conexao = Session.getInstance(propriedades,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                    	//E-mail e senha da clínica
                        return new PasswordAuthentication("naoresponda_clinicdata@outlook.com", "clinicdata00_");
                    }
                });
        //Tenta enviar a mensagem
        try {
        	//Nova mensagem
            Message mensagem = new MimeMessage(conexao);
            
            //E-mail da clínica
            mensagem.setFrom(new InternetAddress("naoresponda_clinicdata@outlook.com"));
            
            //E-mail do destinatário
            mensagem.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailDoPaciente));
            
            //Título do e-mail
            mensagem.setSubject("Aviso - ClinicSystem");

            //Código HTML
            MimeBodyPart mensagemHtml = new MimeBodyPart();
            
            //Insere o texto de acordo com o tipo de e-mail, se for lembrete ou cancelamento. Caso não seja nenhum dos dois, retorna false.
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
            		+ "<div style=\"text-align: left;padding: 15px;margin-left: 50px;max-width: 392px;word-break: break-word;\">Endereço:<div style=\"display: inline;font-weight: bold;margin-left: 5px;\">ENDEREÇO DA CLÍNICA</div></div></div>\r\n"
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
            		+ "<div style=\"font-size: 15px;color: #4b69a8;margin-top: 20px;\">WhatsApp: (DDD) WHATSAPP DA CLÍNICA</div><div style=\"font-size: 15px;color: #4b69a8;margin-top: 20px;\">E-mail: E-MAIL DA CLÍNICA</div>\r\n"
            		+ "\r\n"
            		+ "<p>Em caso de dúvidas ou reagendamento entre em contato conosco pelos nossos canais de comunicação.</p>\r\n"
            		+ "<p>Nós agradecemos pela compreensão :)</p>\r\n"
            		+ "<p>Equipe NOME DA CLÍNICA</p><p style=\"font-size: 12px;margin-top: 50px;color: silver;\">E-MAIL ENVIADO AUTOMATICAMENTE. POR FAVOR, NÃO RESPONDER</p></div>\r\n"
            		+ "</body>";
            mensagemHtml.setContent(codigo, "text/html; charset=UTF-8");

            //Parte em que o conteúdo da mensagem fica
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mensagemHtml);

            //Adiciona o conteúdo à mensagem
            mensagem.setContent(multipart);

            //Envia a mensagem
            Transport.send(mensagem);
            
            //Retorno do método é true
            return true;

        } catch (MessagingException e) {
        	//Retorno do método é false
            return false;
        }
	}
	
    public static void main(String[] args) {
    	//Exemplo de uso - cancelamento
    	enviarEmail("cancelamento", "paos@discente.ifpe.edu.br", "Paulo", "25/01/2023", "10:00", "Dr. Josevaldo");
    	//Exemplo de uso - lembrete
    	enviarEmail("lembrete", "paos@discente.ifpe.edu.br", "Paulo", "25/01/2023", "10:00", "Dr. Josevaldo");

    }
}

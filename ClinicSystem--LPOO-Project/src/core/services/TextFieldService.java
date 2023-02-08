package core.services;

import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextFieldService extends PlainDocument {

	private int numeroMaximoDeCaracteres;
    
    public TextFieldService(int numeroMaximoDeCaracteres){
        this.numeroMaximoDeCaracteres = numeroMaximoDeCaracteres;
    }
    
    @Override
    public void insertString(int offset, String string, AttributeSet atributo) throws BadLocationException {
 
            if (string == null) {
            	return;  
            }
            
             String stringInserida = getText (0, getLength() );  
             int tamanhoLimitado = stringInserida.length() + string.length(); 
                        
             if (tamanhoLimitado <= numeroMaximoDeCaracteres) {  
                 super.insertString(offset, string , atributo);  
             } else {    
                 super.insertString(offset, "", atributo); 
             }  
    }

    public static boolean validarEmail(String email) {
    	String expressaoVerificadora = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,255}.[a-z]{2,255}.[a-z]{2,255}$";
		Pattern padrao = Pattern.compile(expressaoVerificadora);
    	if (email.isBlank()) {
    		email = "";
    	} 
    	return padrao.matcher(email).matches();
    }

    public static boolean validarNumero(String numero) {
    	String string = numero.replaceAll("\\s+", "").replaceAll("-", "");
    	if (string.matches("[0-9]+") && string.length() == 11) {
    		return true;
    	} 
    	return false;
    }
    
    public static boolean validarCRM(String numero) {
    	String string = numero.replaceAll("\\s+", "");
    	if (string.matches("[0-9]+") && string.length() == 6) {
    		return true;
    	} 
    	return false;
    }
    
    public static boolean validarTextFieldNumerica(JTextField textField) {
    	String numero = textField.getText();
    	String string = numero.replaceAll("\\s+", "").replaceAll("-", "").replaceAll(":", "");
    	if (string.length() < 11) {
    		return true;
    	} else {
    		if (string.matches("[0-9]+")) {
    			return true;
    		} else {
	    		textField.setText("");
	    		return false;
    		}
    	}
    }
    
    public static boolean validarTextFieldData(JTextField textField) {
    	String numero = textField.getText();
    	String string = numero.replaceAll("\\s+", "").replaceAll("/", "");
    	if (string.length() != 8) {
    		return true;
    	} else {
    		if (string.matches("[0-9]+")) {
    			return true;
    		} else {
	    		textField.setText("");
	    		return false;
    		}
    	}
    }
    
    public static boolean validarData(String numero) {
    	String string = numero.replaceAll("/", "");
    	if (string.matches("[0-9]+") && string.length() == 8) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public static boolean validarTextFieldHorario(JTextField textField) {
    	String numero = textField.getText();
    	String string = numero.replaceAll("\\s+", "").replaceAll(":", "");
    	if (string.length() != 4) {
    		return true;
    	} else {
    		if (string.matches("[0-9]+")) {
    			return true;
    		} else {
	    		textField.setText("");
	    		return false;
    		}
    	}
    }
    
    public static boolean validarHorario(String horario) {
    	String numero = horario;
    	String string = numero.replaceAll("\\s+", "").replaceAll(":", "");
    	if (string.matches("[0-9]+") && string.length() == 4) {
    			return true;
    	} else {
	   		return false;
    	}
    }
    
    public static String extrairCpfDaString(String stringRecebida) {
    	String pedaco = "";
    	if (stringRecebida.length() < 14) {
    		pedaco = stringRecebida;
    	} else {
    		pedaco = stringRecebida.substring(1, 12);
    	}
		return pedaco;
    }
    
    
    public static void main(String[] args) {
	}
}

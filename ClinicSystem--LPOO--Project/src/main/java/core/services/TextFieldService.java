package core.services;

import java.util.regex.Pattern;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextFieldService extends PlainDocument {

	private int numeroMaximoDeCaracteres;
    
    public TextFieldService(int numeroMaximoDeCaracteres){
        this.numeroMaximoDeCaracteres = numeroMaximoDeCaracteres;
    }
    
    public TextFieldService() {
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

    public boolean validarEmail(String email) {
    	if (email.isBlank()) {
    		return false;
    	} else {
    		String expressaoVerificadora = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
    		Pattern padrao = Pattern.compile(expressaoVerificadora);
    		boolean resultado = padrao.matcher(email).matches();
    		if (resultado == true) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    }
}

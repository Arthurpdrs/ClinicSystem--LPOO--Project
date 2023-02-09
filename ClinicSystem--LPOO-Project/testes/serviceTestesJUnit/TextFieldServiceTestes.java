package serviceTestesJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import core.services.TextFieldService;

import javax.swing.JTextField;

public class TextFieldServiceTestes {
	
	@Test
	public void testeValidarEmailOk() {
		
		String email = "email@discente.ifpe.edu.br";
		
		assertTrue(TextFieldService.validarEmail(email));
	}
	
	
	@Test
	public void testeValidarEmailNOK() {
		
		String email = "email@dominio";
		
		assertFalse(TextFieldService.validarEmail(email));
	}
	
	
	@Test
	public void testeValidarEmailNull () {
		
		String email = "";
		
		assertFalse(TextFieldService.validarEmail(email));
	}
	
	
	@Test
	public void testeValidarNumeroOk() {
		
		String numero = "12345678901";
		
		assertTrue(TextFieldService.validarNumero(numero));
	}
	
	
	@Test
	public void testeValidarNumeroLengthNOK() {
		
		String numero = "123456789011";
		
		assertFalse(TextFieldService.validarNumero(numero));
	}
	
	@Test
	public void testeValidarNumeroMatchesNOK() {
		
		String numero = "123456789JK";
		
		assertFalse(TextFieldService.validarNumero(numero));
	}
	
	
	@Test
	public void testeValidarNumeroNull () {
		
		String numero = "";
		
		assertFalse(TextFieldService.validarNumero(numero));
	}
	
	
	@Test
	public void testeValidarCRMOK() {
		
		String numero = "123456";
		
		assertTrue(TextFieldService.validarCRM(numero));
	}
	
	
	@Test
	public void testeValidarCRMLengthNOK() {
		
		String numero = "12345";
		
		assertFalse(TextFieldService.validarCRM(numero));
	}
	
	
	@Test
	public void testeValidarCRMMatchesNOK() {
		
		String numero = "A23456";
		
		assertFalse(TextFieldService.validarCRM(numero));
	}
	
	
	@Test
	public void testeValidarCRMNull() {
		
		String numero = "";
		
		assertFalse(TextFieldService.validarCRM(numero));
	}
	
	
	@Test
	public void testeValidarTextFieldNumericaOK() {
		
		JTextField textField = new JTextField("12345678901");
		
		assertTrue(TextFieldService.validarTextFieldNumerica(textField));
	}
	
	
	@Test
	public void testeValidarTextFieldAlfaNumericaOK() {
		
		JTextField textField = new JTextField("A234");
		
		assertTrue(TextFieldService.validarTextFieldNumerica(textField));
	}
	
	
	@Test
	public void testeValidarTextFieldAlfaNumericaNOK() {
		
		JTextField textField = new JTextField("1234567890A");
		
		assertFalse(TextFieldService.validarTextFieldNumerica(textField));
	}
	
	
	@Test
	public void testeValidarTextFieldDataOk() {
		
		JTextField textField = new JTextField("01/01/2021");
		
		assertTrue(TextFieldService.validarTextFieldData(textField));
	}
	
	
	@Test
	public void testeValidarDataOk() {
		
		String data = "01/01/2021";
		
		assertTrue(TextFieldService.validarData(data));
	}
	
	@Test
	public void testeValidarDataLenghtNOK() {
		
		String data = "01/01/20211";
		
		assertFalse(TextFieldService.validarData(data));
	}
	
	
	@Test
	public void testeValidarDataIsBlank() {
		
		String data = "";
		
		assertFalse(TextFieldService.validarData(data));
	}
	
	
	@Test
	public void testeValidarDataNull() {
		
		assertThrows(NullPointerException.class,
				() -> TextFieldService.validarData(null));
	}
	
	
	@Test
	public void testeValidarTextFieldHorarioOk() {
	
		JTextField textField = new JTextField("09:00");
		
		assertTrue(TextFieldService.validarTextFieldHorario(textField));
	}
	
	
	@Test
	public void testeValidarTextFieldHorarioNOK() {
	
		JTextField textField = new JTextField("09:aa");
		
		assertFalse(TextFieldService.validarTextFieldHorario(textField));
	}
	
}

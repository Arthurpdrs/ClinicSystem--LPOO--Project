package serviceTestesJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import core.services.TextFieldService;

import javax.swing.JTextField;

public class TextFieldServiceTestes {
	
	@Test
	public void testValidarEmail() {
		String emailValido = "email@dominio.com.br";
		String emailInvalido = "email@dominio";
		
		assertTrue(TextFieldService.validarEmail(emailValido));
		assertFalse(TextFieldService.validarEmail(emailInvalido));
	}
	
	@Test
	public void testValidarNumero() {
		String numeroValido = "12345678901";
		String numeroInvalido = "123456789011";
		
		assertTrue(TextFieldService.validarNumero(numeroValido));
		assertFalse(TextFieldService.validarNumero(numeroInvalido));
	}
	
	@Test
	public void testValidarTextFieldNumerica() {
		JTextField textFieldValido = new JTextField("12345678901");
		JTextField textFieldInvalido = new JTextField("1234567890a");
		
		assertTrue(TextFieldService.validarTextFieldNumerica(textFieldValido));
		assertFalse(TextFieldService.validarTextFieldNumerica(textFieldInvalido));
	}
	
	@Test
	public void testValidarTextFieldData() {
		JTextField textFieldValido = new JTextField("01/01/2021");
		JTextField textFieldInvalido = new JTextField("aa/01/2021");
		
		assertTrue(TextFieldService.validarTextFieldData(textFieldValido));
		assertFalse(TextFieldService.validarTextFieldData(textFieldInvalido));
	}
	
	@Test
	public void testValidarData() {
		String dataValida = "01/01/2021";
		String dataInvalida = "01/01/20211";
		
		assertTrue(TextFieldService.validarData(dataValida));
		assertFalse(TextFieldService.validarData(dataInvalida));
	}
	
	@Test
	public void testValidarTextFieldHorario() {
		JTextField textFieldValido = new JTextField("09:00");
		JTextField textFieldInvalido = new JTextField("09:aa");
		
		assertTrue(TextFieldService.validarTextFieldHorario(textFieldValido));
		assertFalse(TextFieldService.validarTextFieldHorario(textFieldInvalido));
	}
}

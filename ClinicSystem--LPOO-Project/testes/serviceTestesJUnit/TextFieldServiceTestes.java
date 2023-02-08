package serviceTestesJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import core.services.TextFieldService;

import javax.swing.JTextField;

public class TextFieldServiceTestes {
	
	@Test
	public void testValidarEmailOk() {
		String emailValido = "email@discente.ifpe.edu.br";
		assertTrue(TextFieldService.validarEmail(emailValido));
	}
	
	@Test
	public void testValidarEmail() {
		String emailInvalido = "email@dominio";
		
		assertFalse(TextFieldService.validarEmail(emailInvalido));
	}
	
	@Test
	public void testValidarNumeroOk() {
		String numeroValido = "12345678901";
		
		assertTrue(TextFieldService.validarNumero(numeroValido));
	}
	
	@Test
	public void testValidarNumero() {
		String numeroInvalido = "123456789011";
		
		assertFalse(TextFieldService.validarNumero(numeroInvalido));
	}
	
	@Test
	public void testValidarTextFieldNumericaOk() {
		JTextField textFieldValido = new JTextField("12345678901");
		
		assertTrue(TextFieldService.validarTextFieldNumerica(textFieldValido));
	}
	
	@Test
	public void testValidarTextFieldNumerica() {
		JTextField textFieldInvalido = new JTextField("1234567890a");
		
		assertFalse(TextFieldService.validarTextFieldNumerica(textFieldInvalido));
	}
	
	@Test
	public void testValidarTextFieldDataOk() {
		JTextField textFieldValido = new JTextField("01/01/2021");
		
		assertTrue(TextFieldService.validarTextFieldData(textFieldValido));
	}
	
	@Test
	public void testValidarTextFieldData() {
		JTextField textFieldValido = new JTextField("01/01/2021");
		
		assertTrue(TextFieldService.validarTextFieldData(textFieldValido));
	}
	
	@Test
	public void testValidarDataOk() {
		String dataValida = "01/01/2021";
		
		assertTrue(TextFieldService.validarData(dataValida));
	}
	
	@Test
	public void testValidarData() {
		String dataInvalida = "01/01/20211";
		
		assertFalse(TextFieldService.validarData(dataInvalida));
	}
	
	@Test
	public void testValidarTextFieldHorarioOk() {
		JTextField textFieldValido = new JTextField("09:00");
		
		assertTrue(TextFieldService.validarTextFieldHorario(textFieldValido));
	}
	
	@Test
	public void testValidarTextFieldHorario() {
		JTextField textFieldInvalido = new JTextField("09:aa");
		
		assertFalse(TextFieldService.validarTextFieldHorario(textFieldInvalido));
	}
}

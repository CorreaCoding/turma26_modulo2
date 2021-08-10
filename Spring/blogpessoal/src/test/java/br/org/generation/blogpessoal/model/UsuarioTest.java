package br.org.generation.blogpessoal.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)// indica que é uma classe de teste do spring
public class UsuarioTest {				//random port define uma porta livre se sua aplicação já esta rodando
    
    public Usuario usuario;
	public Usuario usuarioNulo = new Usuario(); 

	@Autowired
	private  ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	Validator validator = factory.getValidator();

	@BeforeEach // antes de cada
	public void start() {

		LocalDate data = LocalDate.parse("1997-06-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
        usuario = new Usuario(0L, "Gabriel Almeida", "austbiel@email.com.br", "gabriel1018", data); // a parte de usuario é a mão

	}

	@Test // o metodo testa valida atributos é um test
	@DisplayName("✔ Valida Atributos Não Nulos")
	void testValidaAtributos() {

		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario);
		
		System.out.println(violacao.toString());

		assertTrue(violacao.isEmpty());
	}

	@Test
	@DisplayName("✖ Não Valida Atributos Nulos")
	void testNaoValidaAtributos() {

		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuarioNulo);
		
		System.out.println(violacao.toString());

		assertTrue(violacao.isEmpty());
	}

}

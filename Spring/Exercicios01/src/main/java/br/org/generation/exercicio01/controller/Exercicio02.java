package br.org.generation.exercicio01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/exercicio02")
public class Exercicio02 {
	
	@GetMapping
	public String objetivos () {
		return "Quero aprender mais sobre Spring e revisar Banco de Dados.";
	}

}

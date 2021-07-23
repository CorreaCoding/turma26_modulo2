package br.org.generation.exercicio01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercicio01")
public class Exercicio01 {

	@GetMapping
	public String HabilidadesMentalidades() {
		return "Habilidade: Atenção aos Detalhes | Mentalidade: Persistência.";

	}

}

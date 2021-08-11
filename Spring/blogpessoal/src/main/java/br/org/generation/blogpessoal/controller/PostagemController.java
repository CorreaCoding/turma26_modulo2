package br.org.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogpessoal.model.Postagem;
import br.org.generation.blogpessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

	@Autowired
	private PostagemRepository postagemRepository;

	@GetMapping // Buscando todas as postagens do banco
	public ResponseEntity<List<Postagem>> getAll() {

		return ResponseEntity.ok(postagemRepository.findAll()); // Método padrão --> Select*from

	}

	// Buscando uma postagem através do IDS
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable long id) {

		return postagemRepository.findById(id).map(resp -> ResponseEntity.ok(resp))// Se entrar uma resposta correta
				.orElse(ResponseEntity.notFound().build());// Se não acontecer o esperado

	}

	// Buscando Postagem através do título
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {

		// Método assinado na PostagemRepository
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));

	}

	// Criar postagem
	@PostMapping
	public ResponseEntity<Postagem> postPostagem(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));

	}

	// Alterando Postagem
	@PutMapping
	public ResponseEntity<Postagem> putPostagem(@RequestBody Postagem postagem) {

		return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
	}

	// Deletando Postagem através do ID
	@DeleteMapping("/{id}")
	public void deletePostagem(@PathVariable long id) {

		postagemRepository.deleteById(id);

	}

}
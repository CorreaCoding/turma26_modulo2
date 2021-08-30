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

import br.org.generation.blogpessoal.model.Tema;
import br.org.generation.blogpessoal.repository.TemaRepository;

//localhost:8080 --> Servidor local
@RestController // Classe controladora do tipo Rest --> Projeto com interfaces bem definidas, comunicação de aplicações --> Responde requisições
@RequestMapping("/tema") // Esta anotação mapeia o endereço da Classe
@CrossOrigin(origins = "*", allowedHeaders = "*") // SOFEA --> Serve para unir o back-end e o front-end que estejam em servidores diferentes.
public class TemaController {
	
	@Autowired // Injeção de Dependências --> Transferindo a responsabilidade da Interface para o Spring, o Spring passa a gerenciar tudo.
	private TemaRepository temaRepository;
	
	//Listar todas os Temas
	@GetMapping
	public ResponseEntity<List<Tema>> getAll(){
		
			return ResponseEntity.ok(temaRepository.findAll());
	}
	
	// Listar Tema por ID - Método 03: LAMBDA --> É menos verboso
	//Traz apenas umn Tema
	@GetMapping("/{id}")				 //@Path Variable é a "variável de caminho" para realizar esta requisição.
	public ResponseEntity<Tema> getById(@PathVariable long id){
		return temaRepository.findById(id)  //resp equivale a resposta da busca solicitada.
				.map(resp -> ResponseEntity.ok(resp))//Se entrar uma resposta correta
				.orElse(ResponseEntity.notFound().build());// Se não acontecer o esperado
				
	}
	
	//Buscar através da descriçãp
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Tema>> getByDescricao(@PathVariable String descricao){
				
			return ResponseEntity.ok(temaRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	//Criação de Tema
	@PostMapping
	public ResponseEntity<Tema> postTema(@RequestBody Tema tema){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
		
	}
	
	//Atualizando Tema
	@PutMapping
	public ResponseEntity<Tema> putTema(@RequestBody Tema tema){
			
			return ResponseEntity.status(HttpStatus.OK).body(temaRepository.save(tema));
	}
	
	//Deletando Tema
	@DeleteMapping("/{id}")
	public void deleteTema(@PathVariable long id) {
		temaRepository.deleteById(id);
		
	}
	

}
package br.org.generation.lojagames.controller;

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

import br.org.generation.lojagames.model.Categoria;
import br.org.generation.lojagames.repository.CategoriaRepository;


@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	// Injeção de dependências, tranferência de comando de PostagemRepository para o Spring.
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping // Vai listar todas as categorias da tabela --> Select*From tb_categorias
	private ResponseEntity<List<Categoria>> GetAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	// Listar Categorias por ID - Método 03 - Expressão Lambda
		// Função de tamanho menor
		@GetMapping("/{id}")
		private ResponseEntity<Categoria> getById(@PathVariable long id) {
			return categoriaRepository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))// Recebe um objeto, que no caso é a categoria, e converte em um ok. Ou seja, deu certo a busca.
			.orElse(ResponseEntity.notFound().build());
		}

		// Listar todas as Categorias por tipo
		@GetMapping("/tipo/{tipo}")
		public ResponseEntity<List<Categoria>> getByTipo(@PathVariable String tipo) {
			return ResponseEntity.ok(categoriaRepository.findAllByTipoContainingIgnoreCase(tipo)); // Mostra lista de postagens estando vazia ou não
		}

		// Criar Postagem

		@PostMapping
		public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
			return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
		}

		// Alterar Postagem

		@PutMapping
		public ResponseEntity<Categoria> put(@RequestBody Categoria categoria){
			return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
	}
		//Deletar Postagem
		
		@DeleteMapping("/{id}")
		public void deleteCategoria(@PathVariable long id) {
			categoriaRepository.deleteById(id);
		}
		
		
	

	

}

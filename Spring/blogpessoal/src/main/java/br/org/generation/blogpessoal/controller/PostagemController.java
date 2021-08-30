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

//localhost:8080 --> Servidor local
@RestController // Classe controladora do tipo Rest --> Projeto com interfaces bem definidas, comunicação de aplicações --> Responde requisições
@RequestMapping("/postagens") // Esta anotação mapeia o endereço da Classe
@CrossOrigin(origins = "*", allowedHeaders = "*") // SOFEA --> Serve para unir o back-end e o front-end que estejam em servidores diferentes.
public class PostagemController {

	@Autowired // Injeção de Dependências --> Transferindo a responsabilidade da Interface para o Spring, o Spring passa a gerenciar tudo.
	private PostagemRepository postagemRepository;

	//Listar todas as Postagens
	@GetMapping //Aparece mesmo se for vazia quando é <List<>>
	public ResponseEntity<List<Postagem>> getAll() {
		return ResponseEntity.ok(postagemRepository.findAll()); // Método padrão --> findAll que busca todas as postagens da tabela.
	}
	
	/* Listar Postagem por ID - Método 01 - If/Else
	@GetMapping("idifelse/{id}")
	public ResponseEntity<Postagem> getByIdIfElse(@PathVariable long id){
		//Optional diz que pode ter dados ou não.
		Optional<Postagem> postagem = postagemRepository.findById(id); //Faz uma consulta com o id solicitado
		if(postagem.isPresent()) { //If he finds it, then it means that the post is present.
			return ResponseEntity.ok(postagem.get());//Se encontar ele mostra a postagem
		}
		return ResponseEntity.notFound().build();//Se não encontrar ele mostra notFound
	}*/
	
	/*@GetMapping("/idtrycatch/{id}") //Estrutura para pegar erro
	public ResponseEntity<Postagem> getByIdTryCatch(@PathVariable long id){
		Optional<Postagem> postagem = postagemRepository.findById(id);
		try {
			return ResponseEntity.ok(postagem.get()); //Manda um Ok se achar a postagem
		} catch (Exception e) {
			return ResponseEntity.notFound().build(); //Se deu errado, mostra o notFound
		}
	}*/
	
	
	// Listar Postagem por ID - Método 03: LAMBDA --> É menos verboso
	//Traz apenas uma Postagem
	@GetMapping("/{id}")                   //@Path Variable é a "variável de caminho" para realizar esta requisição.
	public ResponseEntity<Postagem> getById(@PathVariable long id) {
		return postagemRepository.findById(id) //resp equivale a resposta da busca solicitada.
				.map(resp -> ResponseEntity.ok(resp))//Se entrar uma resposta correta
				.orElse(ResponseEntity.notFound().build());// Se não acontecer o esperado
	}

	// Buscando Postagem através do título
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
		// Método assinado na PostagemRepository
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));

	}

	// Criar Postagem
	@PostMapping  //Recebe um RequestBody, pois o usuário entra com todos os dados/atributos da classe de Postagem.
	public ResponseEntity<Postagem> postPostagem(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
		//HttpStatus.CREATED confirma que o dado foi criado na tabela
	}

	// Alterando Postagem
	@PutMapping                   //Recebe todas as informações novas dos atributos + o id para identificar qual Postagem que é, se não passar id cria uma nova postagem.
	public ResponseEntity<Postagem> putPostagem(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
	}

	// Deletando Postagem através do ID
	@DeleteMapping("/{id}")
	public void deletePostagem(@PathVariable long id) {
		postagemRepository.deleteById(id);
	}
}
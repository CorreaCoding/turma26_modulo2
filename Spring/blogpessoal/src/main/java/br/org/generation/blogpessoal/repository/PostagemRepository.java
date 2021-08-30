package br.org.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpessoal.model.Postagem;

@Repository// Extends --> Está fazendo uma herança dos métodos da JpaRepository
public interface PostagemRepository  extends JpaRepository<Postagem, Long> {
                                                         //<Classe onde está a tabela, id com L maiúsculo, pois é uma classe>
	//Assinatura de método específico
	public List <Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	//Select*From tb_postagens where titulo like %titulo%
}
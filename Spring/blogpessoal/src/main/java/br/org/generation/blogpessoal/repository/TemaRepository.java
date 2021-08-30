package br.org.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpessoal.model.Tema;

@Repository // Extends --> Está fazendo uma herança dos métodos da JpaRepository
public interface TemaRepository extends JpaRepository<Tema, Long> {

	//Assinatura de método específico
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
	//Select*From tb_postagens where descricao like %descricao%
}
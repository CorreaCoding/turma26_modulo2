package br.org.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.farmacia.model.Categoria;

//Interface serve para assinar um método, quais os seus parâmetros e etc.
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	public List<Categoria> findAllByDescricaoContainingIgnoreCase(String tipo); // Ignora se é com letra maiúscula ou
	// minúscula

}

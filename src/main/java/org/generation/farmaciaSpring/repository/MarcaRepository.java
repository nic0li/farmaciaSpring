package org.generation.farmaciaSpring.repository;

import java.util.List;

import org.generation.farmaciaSpring.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

	public List<Marca> findAllByNomeContainingIgnoreCase (String nome);
	
}

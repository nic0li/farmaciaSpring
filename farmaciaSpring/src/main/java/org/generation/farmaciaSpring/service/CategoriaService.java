package org.generation.farmaciaSpring.service;

import java.util.Optional;

import org.generation.farmaciaSpring.model.Categoria;
import org.generation.farmaciaSpring.model.Produto;
import org.generation.farmaciaSpring.repository.CategoriaRepository;
import org.generation.farmaciaSpring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria cadastroProdutoCategoria(long categoriaId, long produtoId) {
		
		Optional<Produto> produtoExistente = produtoRepository.findById(produtoId);
		
		Optional<Categoria> categoriaExistente = categoriaRepository.findById(categoriaId);
		
		if (produtoExistente.isPresent() && categoriaExistente.isPresent()) {
			
			categoriaExistente.get().getProduto().add(produtoExistente.get());
			
			categoriaRepository.save(categoriaExistente.get());
			
			return categoriaRepository.save(categoriaExistente.get());
		
		}
		
		return null;
		
	}
	
}

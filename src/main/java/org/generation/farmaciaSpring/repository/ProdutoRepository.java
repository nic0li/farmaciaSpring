package org.generation.farmaciaSpring.repository;

import java.util.List;

import org.generation.farmaciaSpring.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	
	public List<Produto> findAllByPrecoLessThanEqual(float preco);
	
	public List<Produto> findAllByPrecoGreaterThanEqual(float preco);
	
	@Query(value = "select * from tb_produto where ativo = :ativo", nativeQuery = true)
	public List<Produto> findAllByAtivo(@Param("ativo") boolean ativo);	
	
	@Query(value = "select * from tb_produto inner join tb_marca on tb_marca.id = tb_produto.marca_id where tb_marca.nome = :marca", nativeQuery = true)
	public List<Produto> findAllProdutoByCategoria(@Param("marca") String marca);
	
}

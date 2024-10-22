package com.teste.hospede.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teste.produto.entities.Produto;


@DataJpaTest
class ProdutoRepositoryTest {
	@Autowired
	private ProdutoRepository produtoRepository;

	@DisplayName("Testando o save")
	@Test
	void testSalvarRespository() {
		// Given / Arrange
		Produto Produto1 = new Produto(null, "Julia Maria", 10.00);
		// When / Act
		Produto saveProduto = produtoRepository.save(Produto1);
		// Then / Assert
		assertNotNull(saveProduto);
		assertTrue(saveProduto.getId() > 0);
	}

	@DisplayName("Testando Get para todos Produtos")
	@Test
	void testGetAllRespository() {
		// Given / Arrange
		Produto produto1 = new Produto(null, "Julia Maria", 10.00);
		Produto produto2 = new Produto(null, "Julio Fernando", 10.00);
		produtoRepository.save(produto1);
		produtoRepository.save(produto2);

		// When / Act
		List<Produto> ProdutoList = produtoRepository.findAll();
		// Then / Assert
		assertNotNull(ProdutoList);
		assertEquals(2, ProdutoList.size());
	}

	@DisplayName("Testando GET by ID")
	@Test
	void testGetById() {

		// Given / Arrange

		Produto Produto1 = new Produto(null, "Beatriz Mendes", 10.00);

		produtoRepository.save(Produto1);

		// When / Act
		Produto saveProduto = produtoRepository.findById(Produto1.getId()).get();

		// Then / Assert
		assertNotNull(saveProduto);
		assertEquals(Produto1.getId(), saveProduto.getId());
	}

	@DisplayName("Testando o update")
	@Test
	void testUpdateProduto() {

		// Given / Arrange

		Produto Produto1 = new Produto(null, "Beatriz Mendes", 20.00);

		produtoRepository.save(Produto1);

		// When / Act
		Produto saveProduto = produtoRepository.findById(Produto1.getId()).get();
		Produto1.setNome("Leonardo");
		Produto1.setPreco(30.00);

		Produto updateProduto = produtoRepository.save(saveProduto);

		// Then / Assert
		assertNotNull(updateProduto);
		assertEquals("Beatriz", updateProduto.getNome());
		assertEquals(30.00, updateProduto.getPreco());
	
	}

	@DisplayName("testando o Delete")
	@Test
	void testDeleteProduto() {

		// Given / Arrange
		Produto Produto1 = new Produto(null, "Beatriz Mendes", 10.00);

		produtoRepository.save(Produto1);

		// When / Act
		produtoRepository.deleteById(Produto1.getId());

		Optional<Produto> produtoOptional = produtoRepository.findById(Produto1.getId());

		// Then / Assert
		assertTrue(produtoOptional.isEmpty());

	}
}
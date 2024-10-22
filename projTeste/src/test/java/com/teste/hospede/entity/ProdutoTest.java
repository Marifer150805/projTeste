package com.teste.hospede.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.teste.produto.entities.Produto;

class ProdutoTest {
	
	private Produto produto;
	
	@BeforeEach
	void setUp() {
		//Arrange
		produto = new Produto(1L, "Julia Maria",  30.00);
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		produto.setId(2L);
		assertEquals(2L,produto.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		//Act
		produto.setNome("Joao Paulo");
		assertEquals("Joao Paulo", produto.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo preco")
	void testPreco() {
		//Act
		produto.setPreco( 30.00);
		assertEquals( 30.00, produto.getPreco());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testContrutorAll() {
		
		//Act 
		Produto novoProduto = new Produto(3L, "Maria", 20.00);
		//Assention
		assertAll("novoProduto", 
				()-> assertEquals(3L, novoProduto.getId()),
				()-> assertEquals("Maria", novoProduto.getNome()),
				()-> assertEquals( 20.00, novoProduto.getPreco()));
	}
}
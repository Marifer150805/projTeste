package com.teste.hospede.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.teste.produto.entities.Veiculo;

class VeiculoTest {
	
	private Veiculo veiculo;
	
	@BeforeEach
	void setUp() {
		//Arrange
		veiculo = new Veiculo("fox", "BMW",  2005, "preto");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo Marca")
	void testId() {
		//Act
		veiculo.setMarca("Honda");
		assertEquals("Honda",veiculo.getMarca());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo modelo")
	void testNome() {
		//Act
		veiculo.setModelo("BMW");
		assertEquals("BMW", veiculo.getModelo());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo ano")
	void testAno() {
		//Act
		veiculo.setAno( 2005);
		assertEquals( 2005, veiculo.getAno());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo cor")
	void testCor() {
		//Act
		veiculo.setCor("preto");
		assertEquals("preto", veiculo.getCor());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testContrutorAll() {
		
		//Act 
		Veiculo novoVeiculo = new Veiculo("Honda", "BMW", 2005, "preto");
		//Assention
		assertAll("novoVeiculo", 
				()-> assertEquals("Honda", novoVeiculo.getMarca()),
				()-> assertEquals("BMW", novoVeiculo.getModelo()),
				()-> assertEquals(2006, novoVeiculo.getAno()),
				()-> assertEquals("preto", novoVeiculo.getCor()));
	}
}
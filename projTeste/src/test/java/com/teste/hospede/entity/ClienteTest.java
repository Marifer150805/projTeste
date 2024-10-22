package com.teste.hospede.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.teste.produto.entities.Cliente;

class ClinteTest {
	
	private Cliente cliente;
	
	@BeforeEach
	void setUp() {
		//Arrange
		cliente = new Cliente(1L, "Bianca",  "159998252460", "474582613542", "58645295695");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		cliente.setId(2L);
		assertEquals(2L,cliente.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		//Act
		cliente.setNome("Joao Paulo");
		assertEquals("Joao Paulo", cliente.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo preco")
	void testTelefone() {
		//Act
		cliente.setTelefone("15998252460");
		assertEquals("15998252460", cliente.getTelefone());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo preco")
	void testCpf() {
		//Act
		cliente.setCpf("47458692135");
		assertEquals("47458692135", cliente.getCpf());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo preco")
	void testRg() {
		//Act
		cliente.setRg("586921356");
		assertEquals("586921356", cliente.getRg());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testContrutorAll() {
		
		//Act 
		Cliente novoCliente = new Cliente(3L, "Maria", "1566982325852", "475862365665", "586433236562");
		//Assention
		assertAll("novoCliente", 
				()-> assertEquals(3L, novoCliente.getId()),
				()-> assertEquals("Maria", novoCliente.getNome()),
				()-> assertEquals("15999632596", novoCliente.getTelefone()),
				()-> assertEquals("4755896215", novoCliente.getCpf()),
				()-> assertEquals("5862259455", novoCliente.getRg()));
		
	}
}
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

import com.teste.produto.entities.Cliente;


@DataJpaTest
class ClienteRepositoryTest {
	@Autowired
	private ClienteRepository clienteRepository;

	@DisplayName("Testando o save")
	@Test
	void testSalvarRespository() {
		// Given / Arrange
		Cliente cliente1 = new Cliente(null, "Julia Maria", "julia@gmail.com", "475812681568", "5896223654");
		// When / Act
		Cliente saveCliente = clienteRepository.save(cliente1);
		// Then / Assert
		assertNotNull(saveCliente);
		assertTrue(saveCliente.getId() > 0);
	}

	@DisplayName("Testando Get para todos Clientes")
	@Test
	void testGetAllRespository() {
		// Given / Arrange
		Cliente cliente1 = new Cliente(null, "Julia Maria", "1599822466", "47586126985", "58265554525");
		Cliente cliente2 = new Cliente(null, "Julio Fernando", "00000000", "44444444", "22222222");
		clienteRepository.save(cliente1);
		clienteRepository.save(cliente2);

		// When / Act
		List<Cliente> clienteList = clienteRepository.findAll();
		// Then / Assert
		assertNotNull(clienteList);
		assertEquals(2, clienteList.size());
	}

	@DisplayName("Testando GET by ID")
	@Test
	void testGetById() {

		// Given / Arrange

		Cliente cliente1 = new Cliente(null, "Beatriz Mendes", "474558522655", "373884884848", "582036565");

		clienteRepository.save(cliente1);

		// When / Act
		Cliente saveCliente = clienteRepository.findById(cliente1.getId()).get();

		// Then / Assert
		assertNotNull(saveCliente);
		assertEquals(cliente1.getId(), saveCliente.getId());
	}

	@DisplayName("Testando o update")
	@Test
	void testUpdateCliente() {

		// Given / Arrange

		Cliente Cliente1 = new Cliente(null, "Beatriz Mendes", "55555555", "373884884848", "88888888");

		clienteRepository.save(Cliente1);

		// When / Act
		Cliente saveCliente = clienteRepository.findById(Cliente1.getId()).get();
		Cliente1.setNome("Leonardo");
		Cliente1.setTelefone("15998525645");
		Cliente1.setCpf("55668542315");
		Cliente1.setRg("5896321542");

		Cliente updateCliente = clienteRepository.save(saveCliente);

		// Then / Assert
		assertNotNull(updateCliente);
		assertEquals("Beatriz", updateCliente.getNome());
		assertEquals("158882654656", updateCliente.getTelefone());
		assertEquals("4444444444", updateCliente.getCpf());
		assertEquals("3333333333", updateCliente.getRg());
	}

	@DisplayName("testando o Delete")
	@Test
	void testDeleteCliente() {

		// Given / Arrange
		Cliente Cliente1 = new Cliente(null, "Beatriz Mendes", "47458226542", "373884884848", "252222222");

		clienteRepository.save(Cliente1);

		// When / Act
		clienteRepository.deleteById(Cliente1.getId());

		Optional<Cliente> ClienteOptional = clienteRepository.findById(Cliente1.getId());

		// Then / Assert
		assertTrue(ClienteOptional.isEmpty());

	}
}
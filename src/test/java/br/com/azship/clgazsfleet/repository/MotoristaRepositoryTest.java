package br.com.azship.clgazsfleet.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.azship.clgazsfleet.Application;
import br.com.azship.clgazsfleet.model.Motorista;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MotoristaRepositoryTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MotoristaRepositoryTest.class);
	
	@Autowired
	MotoristaRepository motoristaRepository;
	
	@Test
	public void testFindByNome() {
		String nome = "Motorista 1";
		Motorista motorista = motoristaRepository.findByNome(nome);
		LOGGER.debug("testFindByNome({}): {}", nome, motorista);
		assertNotNull(motorista);
		assertEquals(nome, motorista.getNome());
	}
	
	@Test
	public void testFindByCpf() {
		String cpf = "11111111111";
		Motorista motorista = motoristaRepository.findByCpf(cpf);
		LOGGER.debug("testFindByCpf({}): {}", cpf, motorista);
		assertNotNull(motorista);
		assertEquals(cpf, motorista.getCpf());
	}

}

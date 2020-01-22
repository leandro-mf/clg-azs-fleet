package br.com.azship.clgazsfleet.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.azship.clgazsfleet.Application;
import br.com.azship.clgazsfleet.model.CategoriaCnh;
import br.com.azship.clgazsfleet.model.Motorista;
import br.com.azship.clgazsfleet.model.Sexo;
import br.com.azship.clgazsfleet.service.MotoristaService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MotoristaServiceImplTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MotoristaServiceImplTest.class);
	
	@Autowired
	MotoristaService motoristaService; 
	
	@Test
	public void testFindAll() {
		int size = 10;
		List<Motorista> motoristas = motoristaService.findAll();
		LOGGER.debug("testFindAll(): {}", motoristas);
		assertNotNull(motoristas);
		assertEquals(size, motoristas.size());
	}
	
	@Test
	public void testFindById() {
		Long id = new Long("1");
		Motorista motorista = motoristaService.findById(id);
		LOGGER.debug("testFindById({}): {}", id, motorista);
		assertNotNull(motorista);
		assertEquals(id, motorista.getId());
	}
	
	@Test
	public void testFindByNome() {
		String nome = "Motorista 2";
		Motorista motorista = motoristaService.findByNome(nome);
		LOGGER.debug("testFindNome({}): {}", nome, motorista);
		assertNotNull(motorista);
		assertEquals(nome, motorista.getNome());
	}
	
	@Test
	public void testFindByCpf() {
		String cpf = "22222222222";
		Motorista motorista = motoristaService.findByCpf(cpf);
		LOGGER.debug("testFindCpf({}): {}", cpf, motorista);
		assertNotNull(motorista);
		assertEquals(cpf, motorista.getCpf());
	}
	
	@Test
	public void testSave() {
		Motorista motorista = new Motorista();
		motorista.setNome("Motorista 0");
		motorista.setCpf("01234567890");
		motorista.setDataNascimento(LocalDate.of(1997, 7, 7));
		motorista.setSexo(Sexo.getInstance(0));
		motorista.setCategoriaCnh(CategoriaCnh.getInstance(0));
		motorista.setNumeroCnh("00000000000");
		motorista.setExpedicaoCnh(LocalDate.of(2020, 2, 1));
		motorista.setValidadeCnh(LocalDate.of(2025, 2, 1));
		Motorista savedMotorista = motoristaService.save(motorista);
		LOGGER.debug("testSave({}): {}", motorista, savedMotorista);
		assertNotNull(savedMotorista);
		assertEquals(motorista.getCpf(), savedMotorista.getCpf());
	}
	
	@Test
	public void testUpdate() {
		Motorista motorista = new Motorista();
		motorista.setId(new Long("4"));
		motorista.setSexo(Sexo.getInstance(1));
		Motorista updatedMotorista = motoristaService.update(motorista);
		LOGGER.debug("testUpdate({}): {}", motorista, updatedMotorista);
		assertNotNull(updatedMotorista);
		assertEquals(motorista.getSexo(), updatedMotorista.getSexo());
	}
	
	@Test
	public void testDelete() {
		Long id = new Long("4");
		motoristaService.delete(id);
		Motorista motorista = motoristaService.findById(id);
		LOGGER.debug("testDelete({}): {}", id, motorista);
		assertNull(motorista);
	}

}

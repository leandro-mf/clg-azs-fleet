package br.com.azship.clgazsfleet.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.azship.clgazsfleet.Application;
import br.com.azship.clgazsfleet.model.Viagem;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ViagemRepositoryTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ViagemRepositoryTest.class);
	
	@Autowired
	ViagemRepository viagemRepository;
	
	@Test
	public void testFindByMotorista_id() {
		Long id = new Long("2");
		Viagem viagem = viagemRepository.findByMotorista_id(id);
		LOGGER.debug("testFindByMotorista_id({}): {}", id, viagem);
		assertNotNull(viagem);
		assertEquals(id, viagem.getMotorista().getId());
	}
	
	@Test
	public void testFindByVeiculo_id() {
		Long id = new Long("2");
		Viagem viagem = viagemRepository.findByVeiculo_id(id);
		LOGGER.debug("testFindByVeiculo_id({}): {}", id, viagem);
		assertNotNull(viagem);
		assertEquals(id, viagem.getVeiculo().getId());
	}
	
	@Test
	public void testFindByDataInicio() {
		LocalDate dataInicio = LocalDate.of(2020, 9, 9);
		Viagem viagem = viagemRepository.findByDataInicio(dataInicio);
		LOGGER.debug("testFindByDataInicio({}): {}", dataInicio, viagem);
		assertNotNull(viagem);
		assertEquals(dataInicio.getYear(), viagem.getDataInicio().getYear());
		assertEquals(dataInicio.getMonthValue(), viagem.getDataInicio().getMonthValue());
		assertEquals(dataInicio.getDayOfMonth(), viagem.getDataInicio().getDayOfMonth());
	}
	
	@Test
	public void testFindByDataFim() {
		LocalDate dataFim = LocalDate.of(2020, 2, 2);
		Viagem viagem = viagemRepository.findByDataFim(dataFim);
		LOGGER.debug("testFindByDataFim({}): {}", dataFim, viagem);
		assertNotNull(viagem);
		assertEquals(dataFim.getYear(), viagem.getDataFim().getYear());
		assertEquals(dataFim.getMonthValue(), viagem.getDataFim().getMonthValue());
		assertEquals(dataFim.getDayOfMonth(), viagem.getDataFim().getDayOfMonth());
	}
	
}

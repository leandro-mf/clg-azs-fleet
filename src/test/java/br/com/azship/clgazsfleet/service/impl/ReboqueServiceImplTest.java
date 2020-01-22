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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.azship.clgazsfleet.Application;
import br.com.azship.clgazsfleet.model.Reboque;
import br.com.azship.clgazsfleet.model.TipoReboque;
import br.com.azship.clgazsfleet.service.VeiculoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ReboqueServiceImplTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReboqueServiceImplTest.class);
	
	@Autowired
	@Qualifier("reboqueService")
	VeiculoService<Reboque> reboqueService; 
	
	@Test
	public void testFindAll() {
		int size = 4;
		List<Reboque> reboques = reboqueService.findAll();
		LOGGER.debug("testFindAll(): {}", reboques);
		assertNotNull(reboques);
		assertEquals(size, reboques.size());
	}
	
	@Test
	public void testFindById() {
		Long id = new Long("7");
		Reboque reboque = reboqueService.findById(id);
		LOGGER.debug("testFindById({}): {}", id, reboque);
		assertNotNull(reboque);
		assertEquals(id, reboque.getId());
	}
	
	@Test
	public void testFindByPlaca() {
		String placa = "AAA8888";
		Reboque reboque = reboqueService.findByPlaca(placa);
		LOGGER.debug("testFindByPlaca({}): {}", placa, reboque);
		assertNotNull(reboque);
		assertEquals(placa, reboque.getPlaca());
	}
	
	@Test
	public void testSave() {
		Reboque reboque = new Reboque();
		reboque.setPlaca("TTT1111");
		reboque.setCidade("Uberaba");
		reboque.setEstado("MG");
		reboque.setRenavam("Renavam 1");
		reboque.setChassi("Chassi 1");
		reboque.setFabricante("Fabricante 1");
		reboque.setModelo("Modelo 1");
		reboque.setAnoFabricacao(LocalDate.of(2020, 2, 2));
		reboque.setTipoReboque(TipoReboque.getInstance(1));
		Reboque savedReboque = reboqueService.save(reboque);
		LOGGER.debug("testSave({}): {}", reboque, savedReboque);
		assertNotNull(savedReboque);
		assertEquals(reboque.getChassi(), savedReboque.getChassi());
	}
	
	@Test
	public void testUpdate() {
		Reboque reboque = new Reboque();
		reboque.setId(new Long("7"));
		reboque.setTipoReboque(TipoReboque.getInstance(0));
		Reboque updatedReboque = reboqueService.update(reboque);
		LOGGER.debug("testUpdate({}): {}", reboque, updatedReboque);
		assertNotNull(updatedReboque);
		assertEquals(reboque.getTipoReboque(), updatedReboque.getTipoReboque());
	}
	
	@Test
	public void testDelete() {
		Long id = new Long("7");
		reboqueService.delete(id);
		Reboque reboque = reboqueService.findById(id);
		LOGGER.debug("testDelete({}): {}", id, reboque);
		assertNull(reboque);
	}
	
}

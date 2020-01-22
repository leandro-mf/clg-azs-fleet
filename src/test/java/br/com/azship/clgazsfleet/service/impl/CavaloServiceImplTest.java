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
import br.com.azship.clgazsfleet.model.Cavalo;
import br.com.azship.clgazsfleet.model.TipoCavalo;
import br.com.azship.clgazsfleet.service.VeiculoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CavaloServiceImplTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(CavaloServiceImplTest.class);
	
	@Autowired
	@Qualifier("cavaloService")
	VeiculoService<Cavalo> cavaloService; 
	
	@Test
	public void testFindAll() {
		int size = 3;
		List<Cavalo> cavalos = cavaloService.findAll();
		LOGGER.debug("testFindAll(): {}", cavalos);
		assertNotNull(cavalos);
		assertEquals(size, cavalos.size());
	}
	
	@Test
	public void testFindById() {
		Long id = new Long("4");
		Cavalo cavalo = cavaloService.findById(id);
		LOGGER.debug("testFindById({}): {}", id, cavalo);
		assertNotNull(cavalo);
		assertEquals(id, cavalo.getId());
	}
	
	@Test
	public void testFindByPlaca() {
		String placa = "AAA5555";
		Cavalo cavalo = cavaloService.findByPlaca(placa);
		LOGGER.debug("testFindByPlaca({}): {}", placa, cavalo);
		assertNotNull(cavalo);
		assertEquals(placa, cavalo.getPlaca());
	}
	
	@Test
	public void testSave() {
		Cavalo cavalo = new Cavalo();
		cavalo.setPlaca("TTT0000");
		cavalo.setCidade("Uberlandia");
		cavalo.setEstado("MG");
		cavalo.setRenavam("Renavam 0");
		cavalo.setChassi("Chassi 0");
		cavalo.setFabricante("Fabricante 0");
		cavalo.setModelo("Modelo 0");
		cavalo.setAnoFabricacao(LocalDate.of(2020, 1, 1));
		cavalo.setTipoCavalo(TipoCavalo.getInstance(0));
		Cavalo savedCavalo = cavaloService.save(cavalo);
		LOGGER.debug("testSave({}): {}", cavalo, savedCavalo);
		assertNotNull(savedCavalo);
		assertEquals(cavalo.getModelo(), savedCavalo.getModelo());
	}
	
	@Test
	public void testUpdate() {
		Cavalo cavalo = new Cavalo();
		cavalo.setId(new Long("4"));
		cavalo.setTipoCavalo(TipoCavalo.getInstance(1));
		Cavalo updatedCavalo = cavaloService.update(cavalo);
		LOGGER.debug("testUpdate({}): {}", cavalo, updatedCavalo);
		assertNotNull(updatedCavalo);
		assertEquals(cavalo.getTipoCavalo(), updatedCavalo.getTipoCavalo());
	}
	
	@Test
	public void testDelete() {
		Long id = new Long("4");
		cavaloService.delete(id);
		Cavalo cavalo = cavaloService.findById(id);
		LOGGER.debug("testDelete({}): {}", id, cavalo);
		assertNull(cavalo);
	}
	
}

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
import br.com.azship.clgazsfleet.model.Veiculo;
import br.com.azship.clgazsfleet.service.VeiculoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class VeiculoServiceImplTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VeiculoServiceImplTest.class);
	
	@Autowired
	@Qualifier("veiculoService")
	VeiculoService<Veiculo> veiculoService; 
	
	@Test
	public void testFindAll() {
		int size = 11;
		List<Veiculo> veiculos = veiculoService.findAll();
		LOGGER.debug("testFindAll(): {}", veiculos);
		assertNotNull(veiculos);
		assertEquals(size, veiculos.size());
	}
	
	@Test
	public void testFindById() {
		Long id = new Long("2");
		Veiculo veiculo = veiculoService.findById(id);
		LOGGER.debug("testFindById({}): {}", id, veiculo);
		assertNotNull(veiculo);
		assertEquals(id, veiculo.getId());
	}
	
	@Test
	public void testFindByPlaca() {
		String placa = "AAA0000";
		Veiculo veiculo = veiculoService.findByPlaca(placa);
		LOGGER.debug("testFindByPlaca({}): {}", placa, veiculo);
		assertNotNull(veiculo);
		assertEquals(placa, veiculo.getPlaca());
	}
	
	@Test
	public void testSave() {
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("BBB9999");
		veiculo.setCidade("Ituiutaba");
		veiculo.setEstado("MG");
		veiculo.setRenavam("Renavam 9");
		veiculo.setChassi("Chassi 9");
		veiculo.setFabricante("Fabricante 9");
		veiculo.setModelo("Modelo 9");
		veiculo.setAnoFabricacao(LocalDate.of(2015, 10, 1));
		Veiculo savedVeiculo = veiculoService.save(veiculo);
		LOGGER.debug("testSave({}): {}", veiculo, savedVeiculo);
		assertNotNull(savedVeiculo);
		assertEquals(veiculo.getCidade(), savedVeiculo.getCidade());
	}
	
	@Test
	public void testUpdate() {
		Veiculo veiculo = new Veiculo();
		veiculo.setId(new Long("2"));
		veiculo.setPlaca("DDD7777");
		Veiculo updatedVeiculo = veiculoService.update(veiculo);
		LOGGER.debug("testUpdate({}): {}", veiculo, updatedVeiculo);
		assertNotNull(updatedVeiculo);
		assertEquals(veiculo.getPlaca(), updatedVeiculo.getPlaca());
	}
	
	@Test
	public void testDelete() {
		Long id = new Long("1");
		veiculoService.delete(id);
		Veiculo veiculo = veiculoService.findById(id);
		LOGGER.debug("testDelete({}): {}", id, veiculo);
		assertNull(veiculo);
	}

}

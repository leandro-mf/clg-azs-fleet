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
import br.com.azship.clgazsfleet.model.Motorista;
import br.com.azship.clgazsfleet.model.StatusViagem;
import br.com.azship.clgazsfleet.model.Veiculo;
import br.com.azship.clgazsfleet.model.Viagem;
import br.com.azship.clgazsfleet.service.ViagemService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ViagemServiceImplTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ViagemServiceImplTest.class);
	
	@Autowired
	ViagemService viagemService; 
	
	@Test
	public void testFindAll() {
		int size = 10;
		List<Viagem> viagens = viagemService.findAll();
		LOGGER.debug("testFindAll(): {}", viagens);
		assertNotNull(viagens);
		assertEquals(size, viagens.size());
	}
	
	@Test
	public void testFindById() {
		Long id = new Long("1");
		Viagem viagem = viagemService.findById(id);
		LOGGER.debug("testFindById({}): {}", id, viagem);
		assertNotNull(viagem);
		assertEquals(id, viagem.getId());
	}
	
	@Test
	public void testFindByMotorista_id() {
		Long id = new Long("1");
		Viagem viagem = viagemService.findByMotorista_id(id);
		LOGGER.debug("testFindByMotorista_id({}): {}", id, viagem);
		assertNotNull(viagem);
		assertEquals(id, viagem.getMotorista().getId());
	}
	
	@Test
	public void testFindByVeiculo_id() {
		Long id = new Long("2");
		Viagem viagem = viagemService.findByVeiculo_id(id);
		LOGGER.debug("testFindByVeiculo_id({}): {}", id, viagem);
		assertNotNull(viagem);
		assertEquals(id, viagem.getVeiculo().getId());
	}
	
	@Test
	public void testFindByDataInicio() {
		LocalDate dataInicio = LocalDate.of(2020, 3, 3);
		Viagem viagem = viagemService.findByDataInicio(dataInicio);
		LOGGER.debug("testFindByDataInicio({}): {}", dataInicio, viagem);
		assertNotNull(viagem);
		assertEquals(dataInicio.getYear(), viagem.getDataInicio().getYear());
		assertEquals(dataInicio.getMonthValue(), viagem.getDataInicio().getMonthValue());
		assertEquals(dataInicio.getDayOfMonth(), viagem.getDataInicio().getDayOfMonth());
	}
	
	@Test
	public void testFindByDataFim() {
		LocalDate dataFim = LocalDate.of(2020, 4, 4);
		Viagem viagem = viagemService.findByDataFim(dataFim);
		LOGGER.debug("testFindByDataFim({}): {}", dataFim, viagem);
		assertNotNull(viagem);
		assertEquals(dataFim, viagem.getDataFim());
		assertEquals(dataFim.getYear(), viagem.getDataFim().getYear());
		assertEquals(dataFim.getMonthValue(), viagem.getDataFim().getMonthValue());
		assertEquals(dataFim.getDayOfMonth(), viagem.getDataFim().getDayOfMonth());
	}
	
	@Test
	public void testSave() {
		Viagem viagem = new Viagem();
		Veiculo veiculo = new Veiculo();
		Motorista motorista = new Motorista();
		veiculo.setId(new Long("1"));
		motorista.setId(new Long("1"));
		viagem.setVeiculo(veiculo);
		viagem.setMotorista(motorista);
		viagem.setDataInicio(LocalDate.of(2019, 12, 5));
		viagem.setDataFim(LocalDate.of(2020, 1, 5));
		viagem.setProdutoTransportado("Produto 0");
		viagem.setValorFrete(new Double("300"));
		viagem.setStatusViagem(StatusViagem.CRIADA);
		Viagem savedViagem = viagemService.save(viagem);
		LOGGER.debug("testFindSave({}): {}", viagem, savedViagem);
		assertNotNull(savedViagem);
		assertEquals(viagem.getProdutoTransportado(), savedViagem.getProdutoTransportado());
	}
	
	@Test
	public void testUpdate() {
		Viagem viagem = new Viagem();
		viagem.setId(new Long("6"));
		viagem.setStatusViagem(StatusViagem.getInstance(1));
		Viagem updatedViagem = viagemService.update(viagem);
		LOGGER.debug("testUpdate({}): {}", viagem, updatedViagem);
		assertNotNull(updatedViagem);
		assertEquals(viagem.getStatusViagem(), updatedViagem.getStatusViagem());
	}
	
	@Test
	public void testDelete() {
		Long id = new Long("6");
		viagemService.delete(id);
		Viagem viagem = viagemService.findById(id);
		LOGGER.debug("testDelete({}): {}", id, viagem);
		assertNull(viagem);
	}

}

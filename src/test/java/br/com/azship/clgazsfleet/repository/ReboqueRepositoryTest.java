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
import br.com.azship.clgazsfleet.model.Reboque;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ReboqueRepositoryTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReboqueRepositoryTest.class);
	
	@Autowired
	ReboqueRepository reboqueRepository;
	
	@Test
	public void testFindByPlaca() {
		String placa = "AAA7777";
		Reboque reboque = reboqueRepository.findByPlaca(placa);
		LOGGER.debug("testFindByPlaca({}): {}", placa, reboque);
		assertNotNull(reboque);
		assertEquals(placa, reboque.getPlaca());
	}
	
}

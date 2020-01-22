package br.com.azship.clgazsfleet.model;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.agileware.test.PropertiesTester;
import org.junit.jupiter.api.Test;

public class VeiculoTest {

	@Test
	public void testGettersAndSetters() throws Exception {
		PropertiesTester propertiesTester = new PropertiesTester();
		propertiesTester.addMapping(LocalDate.class, LocalDate.of(2020, 1, 1));
		propertiesTester.testAll(Veiculo.class);
	}

	@Test
	public void testToString() {
		Veiculo veiculo = new Veiculo();
		assertNotNull(veiculo.toString());
	}
	
}

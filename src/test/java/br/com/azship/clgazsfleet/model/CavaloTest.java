package br.com.azship.clgazsfleet.model;

import static org.junit.Assert.assertNotNull;

import org.agileware.test.PropertiesTester;
import org.junit.jupiter.api.Test;

public class CavaloTest {

	@Test
	public void testGettersAndSetters() throws Exception {
		PropertiesTester propertiesTester = new PropertiesTester();
		propertiesTester.testAll(Cavalo.class);
	}
	
	@Test
	public void testToString() {
		Cavalo cavalo = new Cavalo();
		assertNotNull(cavalo.toString());
	}
	
}

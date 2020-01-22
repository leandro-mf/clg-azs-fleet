package br.com.azship.clgazsfleet.model;

import static org.junit.Assert.assertNotNull;

import org.agileware.test.PropertiesTester;
import org.junit.jupiter.api.Test;

public class ReboqueTest {

	@Test
	public void testGettersAndSetters() throws Exception {
		PropertiesTester propertiesTester = new PropertiesTester();
		propertiesTester.testAll(Reboque.class);
	}
	
	@Test
	public void testToString() {
		Reboque reboque = new Reboque();
		assertNotNull(reboque.toString());
	}

}

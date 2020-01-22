package br.com.azship.clgazsfleet.model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.agileware.test.PropertiesTester;
import org.junit.jupiter.api.Test;

public class SexoTest {

	private int code;
	
	@Test
	public void testGettersAndSetters() throws Exception {
		PropertiesTester propertiesTester = new PropertiesTester();
		propertiesTester.testAll(Sexo.class);
	}
	
	@Test
	public void testGetInstanceNull() {
		code = -1;
		assertNull(Sexo.getInstance(code));
	}
	
	@Test
	public void testGetInstance0() {
		code = 0;
		assertEquals(Sexo.MASCULINO, Sexo.getInstance(code));
	}
	
	@Test
	public void testGetInstance1() {
		code = 1;
		assertEquals(Sexo.FEMININO, Sexo.getInstance(code));
	}

}

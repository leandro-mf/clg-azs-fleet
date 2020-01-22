package br.com.azship.clgazsfleet.model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.agileware.test.PropertiesTester;
import org.junit.jupiter.api.Test;

public class StatusViagemTest {

	private int code;
	
	@Test
	public void testGettersAndSetters() throws Exception {
		PropertiesTester propertiesTester = new PropertiesTester();
		propertiesTester.testAll(StatusViagem.class);
	}
	
	@Test
	public void testGetInstanceNull() {
		code = -1;
		assertNull(StatusViagem.getInstance(code));
	}
	
	@Test
	public void testGetInstance0() {
		code = 0;
		assertEquals(StatusViagem.CRIADA, StatusViagem.getInstance(code));
	}
	
	@Test
	public void testGetInstance1() {
		code = 1;
		assertEquals(StatusViagem.INICIADA, StatusViagem.getInstance(code));
	}

	@Test
	public void testGetInstance2() {
		code = 2;
		assertEquals(StatusViagem.FINALIZADA, StatusViagem.getInstance(code));
	}
	
}

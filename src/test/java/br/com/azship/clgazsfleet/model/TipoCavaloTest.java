package br.com.azship.clgazsfleet.model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.agileware.test.PropertiesTester;
import org.junit.jupiter.api.Test;

public class TipoCavaloTest {

	private int code;
	
	@Test
	public void testGettersAndSetters() throws Exception {
		PropertiesTester propertiesTester = new PropertiesTester();
		propertiesTester.testAll(TipoCavalo.class);
	}
	
	@Test
	public void testGetInstanceNull() {
		code = -1;
		assertNull(TipoCavalo.getInstance(code));
	}
	
	@Test
	public void testGetInstance0() {
		code = 0;
		assertEquals(TipoCavalo.TRUCADO, TipoCavalo.getInstance(code));
	}
	
	@Test
	public void testGetInstance1() {
		code = 1;
		assertEquals(TipoCavalo.SIMPLES, TipoCavalo.getInstance(code));
	}

}

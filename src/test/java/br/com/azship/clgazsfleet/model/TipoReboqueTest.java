package br.com.azship.clgazsfleet.model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.agileware.test.PropertiesTester;
import org.junit.jupiter.api.Test;

public class TipoReboqueTest {

	private int code;

	@Test
	public void testGettersAndSetters() throws Exception {
		PropertiesTester propertiesTester = new PropertiesTester();
		propertiesTester.testAll(TipoReboque.class);
	}
	
	@Test
	public void testGetInstanceNull() {
		code = -1;
		assertNull(TipoReboque.getInstance(code));
	}

	@Test
	public void testGetInstance0() {
		code = 0;
		assertEquals(TipoReboque.BAU, TipoReboque.getInstance(code));
	}

	@Test
	public void testGetInstance1() {
		code = 1;
		assertEquals(TipoReboque.SIDER, TipoReboque.getInstance(code));
	}

	@Test
	public void testGetInstance2() {
		code = 2;
		assertEquals(TipoReboque.GRADE_BAIXA, TipoReboque.getInstance(code));
	}

	@Test
	public void testGetInstance3() {
		code = 3;
		assertEquals(TipoReboque.BAU_FRIGORIFICO, TipoReboque.getInstance(code));
	}

	@Test
	public void testGetInstance4() {
		code = 4;
		assertEquals(TipoReboque.TANQUE, TipoReboque.getInstance(code));
	}

}

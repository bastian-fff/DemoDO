package com.sophos.demodo.test;

import com.sophos.demodo.DemoDO;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;

public class TestDemoDO {

	@Test
	public void testSumar() {
		Assert.assertEquals(
			"Resultado errado",
			10,
			DemoDO.sumar(5,5)
		);

		Assert.assertEquals(
			"Resultado errado",
			54,
			DemoDO.sumar(45, 9)
		);

		Assert.assertEquals(
			"Resultado errado",
			5,
			DemoDO.sumar(5,0)
		);

		Assert.assertEquals(
			"Resultado errado",
			-25,
			DemoDO.sumar(-5,-20)
		);
	}

	@Test
	public void testRestar() {
		Assert.assertEquals(
			"Resultado errado",
			5,
			DemoDO.restar(10, 5)
		);

		Assert.assertEquals(
			"Resultado errado",
			-15,
			DemoDO.restar(-10, 5)
		);

		Assert.assertEquals(
			"Resultado errado",
			10,
			DemoDO.restar(10, 0)
		);
	}

	@Test
	public void testMultiplicar() {
		Assert.assertEquals(
			"Resultado errado",
			50,
			DemoDO.multiplicar(10, 5)
		);

		Assert.assertEquals(
			"Resultado errado",
			-50,
			DemoDO.multiplicar(-10, 5)
		);

		Assert.assertEquals(
			"Resultado errado",
			-50,
			DemoDO.multiplicar(10, -5)
		);

		Assert.assertEquals(
			"Resultado errado",
			10,
			DemoDO.multiplicar(10, 1)
		);

		Assert.assertEquals(
			"Resultado errado",
			0,
			DemoDO.multiplicar(10, 0)
		);
	}

	@Test
	public void testDividir() {
		try {
  			DemoDO.dividir(10, 0);
  			Assert.fail("Resultado errado");
		} catch (ArithmeticException e) {}
		
		Assert.assertEquals(
			"Resultado errado",
			2,
			DemoDO.dividir(10, 5)
		);

		Assert.assertEquals(
			"Resultado errado",
			-2,
			DemoDO.dividir(-10, 5)
		);

		Assert.assertEquals(
			"Resultado errado",
			-2,
			DemoDO.dividir(10, -5)
		);

		Assert.assertEquals(
			"Resultado errado",
			0,
			DemoDO.dividir(0, 100)
		);

		Assert.assertEquals(
			"Resultado errado",
			10,
			DemoDO.dividir(10, 1)
		);
	}
	
	@Test
	public void testPow(){
		Assert.assertEquals(
			"Resultado incorrecto",
			8,
			DemoDO.exponencial(2,3)
		);
		
		Assert.assertEquals(
			"Resultado incorrecto",
			1,
			DemoDO.exponencial(2,0)
		);
		
		Assert.assertEquals(
			"Resultado incorrecto",
			2,
			DemoDO.exponencial(2,1)
		);
		
		Assert.assertEquals(
			"Resultado incorrecto",
			0,
			DemoDO.exponencial(2,-1)
		);
	}

	@Test
	public void testCalcular() {
		// Flujo normal
		Assert.assertThat(
			"Mensaje de salida no corresponde",
			DemoDO.calcular(81, 9),
			CoreMatchers.allOf(
				StringContains.containsString("(81 + 9) = 90"),
				StringContains.containsString("(81 - 9) = 72"),
				StringContains.containsString("(81 x 9) = 729"),
				StringContains.containsString("(81 / 9) = 9")
			)
		);
		
		// Flujo con división por cero
		try {
  			DemoDO.calcular(0, 0);
  			Assert.fail("Resultado errado");
		} catch (ArithmeticException e) {}
	}

}

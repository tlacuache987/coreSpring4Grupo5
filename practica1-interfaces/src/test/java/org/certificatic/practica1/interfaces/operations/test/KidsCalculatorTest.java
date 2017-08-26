package org.certificatic.practica1.interfaces.operations.test;

import java.text.DecimalFormat;

import org.certificatic.practica1.interfaces.operations.api.IKidsCalculator;
import org.certificatic.practica1.interfaces.operations.api.ISimpleCalculator;
import org.certificatic.practica1.interfaces.operations.api.impl.KidsCalculator;
import org.certificatic.practica1.interfaces.operations.api.impl.SimpleCalculator;
import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KidsCalculatorTest {

	private DecimalFormat df = new DecimalFormat("#.00##");

	@Test
	public void kidsCalculatorTest() {
		log.info("kidsCalculatorTest -------------------");

		// Implementar
		ISimpleCalculator simple = new SimpleCalculator();
		IKidsCalculator kids = new KidsCalculator();

		final double expectedValue = 12D;

		final double result = kids.set(5).add(5).add(5).add(-5).substract(4).result();

		Assert.assertEquals(expectedValue, result, 0.0001);
	}

}

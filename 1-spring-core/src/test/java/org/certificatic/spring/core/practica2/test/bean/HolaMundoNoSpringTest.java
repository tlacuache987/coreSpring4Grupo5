package org.certificatic.spring.core.practica2.test.bean;

import org.certificatic.spring.core.practica2.bean.HolaMundo;
import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HolaMundoNoSpringTest {

	@Test
	public void holaMundoNoSpringTest() {
		log.info("holaMundoNoSpringTest -------------------------");

		// Crear instancia de HolaMundo
		HolaMundo holaMundo = new HolaMundo();
		
		holaMundo.setMensaje("Hola Mundo");
		
		Assert.assertNotNull(holaMundo.getMensaje());
		log.info("holaMundo: {}", holaMundo);

	}
}

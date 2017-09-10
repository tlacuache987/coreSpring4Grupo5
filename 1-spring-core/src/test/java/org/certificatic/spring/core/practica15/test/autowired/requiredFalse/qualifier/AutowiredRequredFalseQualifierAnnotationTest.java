package org.certificatic.spring.core.practica15.test.autowired.requiredFalse.qualifier;

import org.certificatic.spring.core.practica15.autowired.requiredFalse.qualifier.bean.Airplane;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredRequredFalseQualifierAnnotationTest {

	@Test
	public void autowiredPropertiesAnnotationTest() {

		log.info("autowiredPropertiesAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-requiredFalse-qualifier-application-context.xml";

		// Implementar
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(ctxFile);

		Airplane airplane = applicationContext.getBean(Airplane.class);

		Assert.assertNotNull(airplane);

		Assert.assertNotNull(airplane.getAirline());

		Assert.assertNull(airplane.getAirplaneCode());

		log.info("airplane: {}", airplane);

		((AbstractApplicationContext) applicationContext).close();
	}

}

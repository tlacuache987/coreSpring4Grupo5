package org.certificatic.spring.core.practica15.test.autowired.constructor;

import org.certificatic.spring.core.practica15.autowired.constructor.bean.Engineer;
import org.certificatic.spring.core.practica15.autowired.properties.bean.Reporter;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredConstructorAnnotationTest {

	@Test
	public void autowiredConstructorAnnotationTest() {

		log.info("autowiredConstructorAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-constructor-application-context.xml";

		// Implementar
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(ctxFile);

		Engineer engineer = applicationContext.getBean(Engineer.class);

		Assert.assertNotNull(engineer);

		Assert.assertNull(engineer.getDni());

		Assert.assertNotNull(engineer.getName());

		Assert.assertNotNull(engineer.getAge());

		Assert.assertNotNull(engineer.getNotebook());

		Assert.assertNotNull(engineer.getPen());

		log.info("engineer: {}", engineer);

		((AbstractApplicationContext) applicationContext).close();
	}

}

package org.certificatic.spring.core.practica15.test.autowired.properties;

import org.certificatic.spring.core.practica15.autowired.properties.bean.Reporter;
import org.certificatic.spring.core.practica15.autowired.setter.bean.Journalist;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredPropertiesAnnotationTest {

	@Test
	public void autowiredPropertiesAnnotationTest() {

		log.info("autowiredPropertiesAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-property-application-context.xml";

		// Implementar
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(ctxFile);

		Reporter reporter = applicationContext.getBean(Reporter.class);

		Assert.assertNotNull(reporter);

		Assert.assertNull(reporter.getDni());

		Assert.assertNotNull(reporter.getName());

		Assert.assertNotNull(reporter.getAge());

		Assert.assertNotNull(reporter.getNotebook());

		Assert.assertNotNull(reporter.getPen());

		log.info("reporter: {}", reporter);

		((AbstractApplicationContext) applicationContext).close();

	}

}

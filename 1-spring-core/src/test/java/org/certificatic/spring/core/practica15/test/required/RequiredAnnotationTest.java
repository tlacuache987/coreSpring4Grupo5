package org.certificatic.spring.core.practica15.test.required;

import org.certificatic.spring.core.practica15.required.bean.Cameraman;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequiredAnnotationTest {

	@Test
	public void requiredAnnotationTest() {

		log.info("requiredAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-required-application-context.xml";

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(ctxFile);

		Cameraman cameraman = applicationContext.getBean("okCameraman", Cameraman.class);

		Assert.assertNotNull(cameraman);

		Assert.assertNotNull(cameraman.getName());

		Assert.assertNotNull(cameraman.getDni());

		Assert.assertNull(cameraman.getAge());

		log.info("cameraman: {}", cameraman);

		((AbstractApplicationContext) applicationContext).close();
	}

	@Test
	public void badRequiredAnnotationTest() {

		log.info("badRequiredAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-required-application-context.xml";

		// Implementar
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(ctxFile);

		try {
			Cameraman cameraman = applicationContext.getBean("badCameraman", Cameraman.class);
			Assert.fail("This test should fail at this line");
		} catch (Exception ex) {
			
		}

		((AbstractApplicationContext) applicationContext).close();
	}
	
	@Test(expected = BeanCreationException.class)
	public void badRequiredAnnotationTest2() {

		log.info("badRequiredAnnotationTest2 -------------------");

		String ctxFile = "spring/practica15/annotations-required-application-context.xml";

		// Implementar
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(ctxFile);

		applicationContext.getBean("badCameraman", Cameraman.class);

		((AbstractApplicationContext) applicationContext).close();
	}

}

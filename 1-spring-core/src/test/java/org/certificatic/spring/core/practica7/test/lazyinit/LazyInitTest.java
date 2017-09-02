package org.certificatic.spring.core.practica7.test.lazyinit;

import org.certificatic.spring.core.practica7.lazyinit.bean.Car;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LazyInitTest {

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		// Instanciar ApplicationContext
		String ruta = "spring/practica7/lazy-init-application-context.xml";
		applicationContext = new ClassPathXmlApplicationContext(ruta);
	}

	@Test
	public void lazyInitTest() {

		log.info("lazyInitTest -------------------");

		// Implementar
		Car car = applicationContext.getBean(Car.class);

		Assert.assertNotNull(car);

		log.info("car: {}", car);

		((AbstractApplicationContext) applicationContext).close();
	}

}

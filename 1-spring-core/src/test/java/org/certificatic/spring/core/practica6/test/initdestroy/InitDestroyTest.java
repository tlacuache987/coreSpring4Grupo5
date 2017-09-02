package org.certificatic.spring.core.practica6.test.initdestroy;

import org.certificatic.spring.core.practica6.initdestroy.bean.ConnectionDataBase;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitDestroyTest {

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		// Instanciar ApplicationContext
		String ruta = "spring/practica6/init-destroy-application-context.xml";
		applicationContext = new ClassPathXmlApplicationContext(ruta);
	}

	@Test
	public void initDestroyTest() {

		log.info("initDestroyTest -------------------");

		// Implementar
		ConnectionDataBase connection = applicationContext.getBean(ConnectionDataBase.class);
		
		Assert.assertNotNull(connection);

		((AbstractApplicationContext) applicationContext).close();
	}

}

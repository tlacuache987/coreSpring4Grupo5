package org.certificatic.spring.core.practica9.test.beandefinheritance.bean;

import org.certificatic.spring.core.practica9.beandefinitioninheritance.bean.ConnectionDataBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanDefinitionInheritanceTest {

	@Test
	public void beanDefinitionInheritanceTest1() {

		log.info("beanDefinitionInheritanceTest1 -------------------");

		// Implementar
		String ruta = "spring/practica9/bean-def-inheritance-application-context.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(ruta);

		ConnectionDataBase connectionProd = applicationContext.getBean("connectionProdBean", ConnectionDataBase.class);
		Assert.assertNotNull(connectionProd);

		connectionProd.showInfo();

		ConnectionDataBase connectionTest = applicationContext.getBean("connectionTestBean", ConnectionDataBase.class);
		Assert.assertNotNull(connectionTest);

		connectionTest.showInfo();

		((AbstractApplicationContext) applicationContext).close();

	}

	@Test
	public void beanDefinitionInheritanceTest2() {

		log.info("beanDefinitionInheritanceTest2 -------------------");

		// Implementar
		String ruta = "spring/practica9/bean-def-inheritance-application-context2.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(ruta);

		ConnectionDataBase connectionProd = applicationContext.getBean("connectionProdBean", ConnectionDataBase.class);
		Assert.assertNotNull(connectionProd);

		connectionProd.showInfo();

		ConnectionDataBase connectionTest = applicationContext.getBean("connectionTestBean", ConnectionDataBase.class);
		Assert.assertNotNull(connectionTest);

		connectionTest.showInfo();

		((AbstractApplicationContext) applicationContext).close();
	}

}

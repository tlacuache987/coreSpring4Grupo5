package org.certificatic.spring.core.practica5.test.scopes;

import org.certificatic.spring.core.practica5.scopes.bean.Persona;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomScopesSpringTest {

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		// Instanciar ApplicationContext
		String ruta = "spring/practica5/scopes-application-context.xml";
		applicationContext = new ClassPathXmlApplicationContext(ruta);
		System.out.println("Termine !");
	}

	@Test
	public void customScopesSpringTest() {

		log.info("scopeSingletonSpringTest -------------------");

		// Implementar
		for (int i = 0; i < 26; i++) {
			Persona p = applicationContext.getBean("personaCustomScopeBean", Persona.class);

			Assert.assertNotNull(p);

			log.info("persona: {}, {}, {}", p, p.hashCode(), System.identityHashCode(p));
		}
	}

}

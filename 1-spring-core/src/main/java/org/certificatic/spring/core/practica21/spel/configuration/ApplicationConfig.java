package org.certificatic.spring.core.practica21.spel.configuration;

import org.certificatic.spring.core.practica21.spel.bean.MyBeanResolver;
import org.certificatic.spring.core.practica21.spel.model.Inventor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = { "classpath:/spring/practica21/spel-application-context.xml" })
public class ApplicationConfig {

	@Bean
	public Inventor inventor() {
		return new Inventor("Ivan", "Mexicano");
	}

	@Bean
	public MyBeanResolver myBeanResolver() {
		return new MyBeanResolver();
	}

}

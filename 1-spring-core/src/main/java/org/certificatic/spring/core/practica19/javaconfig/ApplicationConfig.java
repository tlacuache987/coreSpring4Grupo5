package org.certificatic.spring.core.practica19.javaconfig;

import org.certificatic.spring.core.practica19.javaconfig.bean.api.IQuadraticEquationService;
import org.certificatic.spring.core.practica19.javaconfig.bean.api.impl.QuadraticEquationServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
// Habilitar Clase de configuración

@ComponentScan(basePackages = { "org.certificatic.spring.core.practica19.javaconfig" })
// Habilitar component scan

@Import({ RepositoryConfig.class, ServiceConfig.class })
// Agregar Import de clases de configuración Repository y Service
public class ApplicationConfig {

	// Definir bean
	@Bean
	public IQuadraticEquationService quadraticService() {
		return new QuadraticEquationServiceImpl();
	}

	// Definir bean
	@Bean(initMethod = "init", destroyMethod = "destroy")
	@Qualifier("quadraticEquationServiceBean")
	public IQuadraticEquationService quadraticService2() {
		return new QuadraticEquationServiceImpl();
	}

	// Definir bean
	@Bean
	@Scope("prototype")
	public IQuadraticEquationService quadraticService3() {
		return new QuadraticEquationServiceImpl();
	}

}

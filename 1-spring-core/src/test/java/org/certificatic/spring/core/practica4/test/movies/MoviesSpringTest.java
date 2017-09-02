package org.certificatic.spring.core.practica4.test.movies;

import org.certificatic.spring.core.practica4.movies.model.Movie;
import org.certificatic.spring.core.practica4.movies.service.MovieListener;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MoviesSpringTest {

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		// Instancia ApplicationContext
		String ruta = "spring/practica4/movies-application-context.xml";
		applicationContext = new ClassPathXmlApplicationContext(ruta);
	}

	@Test
	public void moviesSpringTest() {

		log.info("moviesSpringTest -------------------");

		// Implementa

		MovieListener listener = applicationContext.getBean(MovieListener.class);

		Assert.assertNotNull(listener);
		Assert.assertNotNull(listener.getMovieFinder());

		Movie m = listener.buscaPelicula("Titanic");

		Assert.assertNotNull(m);

		log.info("{}", m);

	}
}

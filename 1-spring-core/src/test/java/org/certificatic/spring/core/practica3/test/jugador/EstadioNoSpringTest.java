package org.certificatic.spring.core.practica3.test.jugador;

import org.certificatic.spring.core.practica3.jugador.JugadorFutbol;
import org.certificatic.spring.core.practica3.liga.Evento;
import org.certificatic.spring.core.practica3.liga.Partido;
import org.certificatic.spring.core.practica3.liga.Torneo;
import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EstadioNoSpringTest {

	@Test
	public void estadioNoSpringTest() {
		log.info("estadioNoSpringTest -------------------");

		// Implementar Test
		Evento evento = new Evento();
		evento.setNombre("Evento X");

		Torneo torneo = new Torneo("Copa America", evento);

		Partido partido = new Partido();
		partido.setNombre("Mexico vs Guatemala");

		JugadorFutbol jugador = new JugadorFutbol();
		jugador.setPartido(partido);
		jugador.setTorneo(torneo);

		Assert.assertNotNull(jugador);
		Assert.assertNotNull(jugador.getPartido());
		Assert.assertNotNull(jugador.getTorneo());
		Assert.assertNotNull(jugador.getTorneo().getEvento());
	}

}

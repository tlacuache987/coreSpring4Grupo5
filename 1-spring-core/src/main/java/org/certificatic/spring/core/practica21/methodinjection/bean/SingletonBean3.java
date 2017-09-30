package org.certificatic.spring.core.practica21.methodinjection.bean;

import org.certificatic.spring.core.practica21.methodinjection.bean.api.IProcessor;
import org.springframework.beans.factory.annotation.Value;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class SingletonBean3 {

	@Value("#{ 1 + 2 }")
	private @Setter Integer iterations;

	// Inyecta un prototype IProcessor en este bean singleton (¿¿¿como????)
	// private IProcessor processor;

	public String process(String data) {
		log.info("SingletonBean id [{}]: sending to process data ...", super.hashCode());

		return getProcessor().processData(data, iterations);
	}

	public abstract IProcessor getProcessor();

}
// Define la estructura para inyectar métodos en èste bean
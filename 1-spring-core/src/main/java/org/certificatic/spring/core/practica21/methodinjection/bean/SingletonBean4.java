package org.certificatic.spring.core.practica21.methodinjection.bean;

import org.certificatic.spring.core.practica21.methodinjection.bean.api.IProcessor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SingletonBean4 {

	@Value("#{ 1 + 2 }")
	private @Setter Integer iterations;

	// Inyecta un prototype IProcessor en este bean singleton (¿¿¿como????)
	// private IProcessor processor;

	public String process(String data) {
		log.info("SingletonBean id [{}]: sending to process data ...", super.hashCode());

		return getProcessor().processData(data, iterations);
	}

	@Lookup("stringProcessor")
	public IProcessor getProcessor() {
		return null;
	}

}
// Define la estructura para inyectar métodos en èste bean
package org.certificatic.spring.core.practica21.methodinjection.bean.api.impl;

import org.certificatic.spring.core.practica21.methodinjection.bean.api.IProcessor;
import org.certificatic.spring.core.utils.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("stringProcessor")
@Scope("prototype")
public class StringProcessor implements IProcessor {

	@Override
	public String processData(String data, Integer iterations) {
		log.info("StringProcessor id [{}]: processing data ...", super.hashCode());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < iterations; i++) {
			sb.append(StringUtils.reverseString(data));
			if (i < iterations - 1)
				sb.append("\n");
		}

		return sb.toString();
	}
}
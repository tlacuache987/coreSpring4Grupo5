package org.certificatic.spring.validation.practica30.parte1.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JacksonXmlRootElement(localName = "person")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	private Integer id;
	private String name;
	private Integer age;
}

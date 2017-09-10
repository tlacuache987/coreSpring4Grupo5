package org.certificatic.spring.core.practica15.autowired.constructor.bean;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Engineer {

	private @Setter(AccessLevel.NONE) String name;
	private @Setter(AccessLevel.NONE) Integer age;
	private String dni;
	private @Setter(AccessLevel.NONE) Laptop notebook;
	private @Setter(AccessLevel.NONE) Stylus pen;

	// Inyectar
	@Autowired
	public Engineer(String name, Integer age, Laptop notebook, Stylus pen) {
		super();
		this.name = name;
		this.age = age;
		this.notebook = notebook;
		this.pen = pen;
	}

}

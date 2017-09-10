package org.certificatic.spring.core.practica15.test.autowired.methods;

import org.certificatic.spring.core.practica15.autowired.methods.bean.Student;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredMethodsAnnotationTest {

	@Test
	public void autowiredMethodsAnnotationTest() {

		log.info("autowiredMethodsAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-methods-application-context.xml";

		// Implementar
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(ctxFile);

		Student student = applicationContext.getBean(Student.class);

		Assert.assertNotNull(student);

		Assert.assertNull(student.getDni());

		Assert.assertNotNull(student.getName());

		Assert.assertNotNull(student.getAge());

		Assert.assertNotNull(student.getNotebook());

		Assert.assertNotNull(student.getPen());

		log.info("student: {}", student);

		((AbstractApplicationContext) applicationContext).close();
	}

}

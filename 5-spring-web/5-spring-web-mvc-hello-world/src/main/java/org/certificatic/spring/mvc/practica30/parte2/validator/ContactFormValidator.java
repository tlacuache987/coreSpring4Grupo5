package org.certificatic.spring.mvc.practica30.parte2.validator;

import java.util.List;

import org.certificatic.spring.mvc.practica30.parte2.forms.ContactForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContactFormValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(ContactForm.class);
	}

	public void validate(Object obj, Errors errors) {
		ContactForm contactForm = (ContactForm) obj;

		// Implementar validador
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "enter your name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "", "enter your gender");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "enter your password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "", "confirm your password");

		if (!contactForm.getEmail().matches(EMAIL_PATTERN)) {
			errors.rejectValue("email", "", "enter a valid email");
		}

		if (!contactForm.getPassword().equals(contactForm.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "", "password confirmation not match");
		}

		List<String> courses = contactForm.getCourses();

		if (courses == null || courses.size() < 2) {
			errors.rejectValue("courses", "", "select at least two courses");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tutor", "", "select your tutor");

	}
}
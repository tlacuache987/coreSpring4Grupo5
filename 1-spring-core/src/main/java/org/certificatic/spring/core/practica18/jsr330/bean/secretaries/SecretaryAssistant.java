package org.certificatic.spring.core.practica18.jsr330.bean.secretaries;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;
import org.certificatic.spring.core.practica18.jsr330.bean.Secretary;
import org.certificatic.spring.core.practica18.jsr330.qualifiers.SecretaryAssistantQualifier;

@Named
@Singleton
@SecretaryAssistantQualifier
public class SecretaryAssistant extends Secretary {

	@Override
	@Inject
	@SecretaryAssistantQualifier
	public void setEmployee(Employee employee) {
		super.setEmployee(employee);
	}
	
	/*@Inject
	public SecretaryAssistant(@SecretaryAssistantQualifier Employee employee) {
		super.setEmployee(employee);
	}*/

}

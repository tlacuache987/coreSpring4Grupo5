package org.certificatic.spring.core.practica21.spel.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyBeanResolver implements BeanResolver, ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public Object resolve(EvaluationContext context, String beanName) throws AccessException {
		Object object = null;
		try {
			object = applicationContext.getBean(beanName);
		} catch (NoSuchBeanDefinitionException ex) {
			log.error(ex.getMessage());
		}
		return object;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}

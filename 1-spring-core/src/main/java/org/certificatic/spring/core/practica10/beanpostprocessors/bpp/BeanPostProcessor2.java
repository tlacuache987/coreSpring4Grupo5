package org.certificatic.spring.core.practica10.beanpostprocessors.bpp;

import org.certificatic.spring.core.practica10.beanpostprocessors.bean.Worker;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import lombok.Getter;

public class BeanPostProcessor2 implements BeanPostProcessor, Ordered {

	private @Getter int order = 2;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("[BPP Before Initialization " + order + " ]");

		if (bean instanceof Worker) {
			Worker worker = (Worker) bean;

			System.out.println("[BPP] Worker: " + worker.getName() + ", " + worker.getAge());

			worker.setAge(300);

			System.out.println("[BPP] Worker: " + worker.getName() + ", " + worker.getAge());
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("[BPP After Initialization " + order + " ]");

		if (bean instanceof Worker) {
			Worker worker = (Worker) bean;

			System.out.println("[BPP] Worker: " + worker.getName() + ", " + worker.getAge());

			worker.setAge(30);

			System.out.println("[BPP] Worker: " + worker.getName() + ", " + worker.getAge());
		}

		return bean;
	}

}
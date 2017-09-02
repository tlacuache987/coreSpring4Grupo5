package org.certificatic.spring.core.practica10.beanpostprocessors.bpp;

import org.certificatic.spring.core.practica10.beanpostprocessors.bean.Worker;
import org.certificatic.spring.core.practica10.beanpostprocessors.bean.WorkerProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import lombok.Getter;

public class BeanPostProcessor3 implements BeanPostProcessor, Ordered {

	private @Getter int order = 3;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("[BPP Before Initialization " + order + " ]");
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("[BPP After Initialization " + order + " ]");

		if (bean instanceof Worker) {
			Worker worker = (Worker) bean;
			
			WorkerProxy proxy = new WorkerProxy();
			proxy.setOriginalWorker(worker);
			
			bean = proxy;
		}

		return bean;
	}

}
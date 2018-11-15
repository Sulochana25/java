package com.maven.spring.SpringExample;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
		System.out.println("postProcessAfterInitialization called for bean: " + name);
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
		System.out.println("postProcessBeforeInitialization called for bean: " + name);
		return bean;
	}

}

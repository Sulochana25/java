package com.maven.spring.UnderstandConstructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjection {
	ApplicationContext context;
	SampleBean beanObj;

	public ConstructorInjection() {
		context = new ClassPathXmlApplicationContext("BeanConfig.xml");
	}

	public void callingConstructorWithoutSpecifyingType() {
		System.out.println("setting constructor-arg in order(int,string)");
		beanObj = (SampleBean) context.getBean("withouttype1");
		System.out.println(beanObj.printMessage());

		System.out.println();

		System.out.println("setting constructor-arg in order(string,int)");
		beanObj = (SampleBean) context.getBean("withouttype2");
		System.out.println(beanObj.printMessage());
	}

	public void callingConstructorWithSpecifyingType() {
		System.out.println("setting constructor-arg in order(int,string)");
		beanObj = (SampleBean) context.getBean("withtype1");
		System.out.println(beanObj.printMessage());

		System.out.println();

		System.out.println("setting constructor-arg in order(string,int)");
		beanObj = (SampleBean) context.getBean("withtype2");
		System.out.println(beanObj.printMessage());

	}

}

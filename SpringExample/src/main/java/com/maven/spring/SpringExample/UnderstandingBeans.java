package com.maven.spring.SpringExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UnderstandingBeans {
	public ApplicationContext context;

	public UnderstandingBeans() {
		System.out.println("---- Configuring beans ----");
		context = new ClassPathXmlApplicationContext("BeanConfig.xml");
		System.out.println("Singleton Beans Configured\n");
	}

	public void beanLifeCycle() {

		BeanClass obj = (BeanClass) context.getBean("protocolBean");
		obj.printMessage();
		((ClassPathXmlApplicationContext) context).close();

	}

	public void beanScopes() {

		System.out.println("****Singleton scope****");
		System.out.println("First Object:");
		BeanClass obj = (BeanClass) context.getBean("singletonBean");
		obj.setMessage("Singleton Bean");
		obj.printMessage();

		System.out.println("Second Object");
		obj = (BeanClass) context.getBean("singletonBean");
		obj.printMessage();

		System.out.println("Third Object");
		obj = (BeanClass) context.getBean("singletonBean");
		obj.printMessage();

		System.out.println();

		System.out.println("Prototype Scope: ");
		System.out.println("First Object");
		obj = (BeanClass) context.getBean("protocolBean");
		obj.setMessage("Protocol Bean");
		obj.printMessage();

		System.out.println("\nSecond Object");
		obj = (BeanClass) context.getBean("protocolBean");
		obj.printMessage();

		System.out.println("\nThird Object");
		obj = (BeanClass) context.getBean("protocolBean");
		obj.printMessage();

		System.out.println();
	}

	public void beanInheritance() {

		System.out.println("parent bean properties: ");
		ParentBean parentBean = (ParentBean) context.getBean("parentBean");
		System.out.println("Default College: " + parentBean.getCollege());
		System.out.println("Default City: " + parentBean.getCity());

		System.out.println("\nproperties to Child bean: ");
		ChildBean childBean = (ChildBean) context.getBean("childBean");

		System.out.println("Name: " + childBean.getName());
		System.out.println("Native Place: " + childBean.getNativePlace());
		System.out.println("College: " + childBean.getCollege() + " (inherited from parent)");
		System.out.println("city: " + childBean.getCity() + " (inherited from parent)");

	}
}

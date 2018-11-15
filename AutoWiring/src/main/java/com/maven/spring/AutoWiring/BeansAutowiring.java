package com.maven.spring.AutoWiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansAutowiring {
	public ApplicationContext context;

	public BeansAutowiring() {
		context = new ClassPathXmlApplicationContext("BeanConfig.xml");
	}

	public void beansAutowiring() {

		System.out.println("Autowiring by 'byName': ");
		BeanA beanA = (BeanA) context.getBean("beanByName");
		beanA.printMessage();

		System.out.println("\nAutowiring by 'byType': ");
		BeanA beanByType = (BeanA) context.getBean("beanByType");
		beanByType.printMessage();

		try {
			System.out.println("\nNo autowiring': ");
			BeanA beanNoAutoWire = (BeanA) context.getBean("beanNoAutoWire");
			beanNoAutoWire.printMessage();
		} catch (Exception e) {
			System.out.println(
					"Exception caused because of no autowiring in done either explicitly or implicitly.\nThus no reference is created for beans B and C");
			System.out.println("Exception message: " + e);
		}

		System.out.println("\nAutowiring by 'constructor': ");
		BeanD beanConstructor = (BeanD) context.getBean("beanConstructor");
		beanConstructor.printMessage();
	}

}

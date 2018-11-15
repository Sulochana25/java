package com.maven.spring.InjectionsBeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UnderstandingInjections {
	public ApplicationContext context;

	public UnderstandingInjections() {
		context = new ClassPathXmlApplicationContext("BeanConfig.xml");
	}

	public void beanInjections() {

		FacultyBean faculty = (FacultyBean) context.getBean("facultyBean");
		System.out.println("Expected Output: Faculty assigned for [Subject](property of faculty bean)\n "
				+ "is [professor name](property of inner bean professorBean)(INNER BEAN INJECTION)\n"
				+ " for sections [sections list](list property of inner bean)(INJECTING COLLECTIONS)");

		System.out.println("\n Output:");
		System.out.println(faculty.toString());

	}

}

package com.maven.spring.JavaBasedConfigAndEvents;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaBasedConfiguration {
	ConfigurableApplicationContext context;
	ConfigurableApplicationContext timeContext;

	public void javaBasedConfig() {
		context = new AnnotationConfigApplicationContext(JavaBasedConfig.class, ImportJavaBasedConfig.class,
				ApplicationEventHandlersBean.class);
		timeContext = new AnnotationConfigApplicationContext(CustomEventConfig.class);

		PrintTimeEventPublisher time = (PrintTimeEventPublisher) timeContext.getBean("printTimeEventPublisher");

		time.getTime();
		context.start();

		time.getTime();
		Faculty faculty = (Faculty) context.getBean("faculty");
		faculty.printMessage();

		System.out.println();

		Organisation organisation = (Organisation) context.getBean("org");
		organisation.printMessage();

		time.getTime();
		System.out.println("Professor for " + organisation.getFaculty().getSubject() + " is "
				+ organisation.getFaculty().getProfessor().getName() + " for college " + organisation.getOrgName());

		time.getTime();
		context.stop();
		time.getTime();
		context.close();
		time.getTime();
	}

}

package com.ggktech.spring.SpringJDBC;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		SampleRefresh obj = (SampleRefresh) ctx.getBean("testTemplate");
		ctx.refresh();
		obj.logRefresh(ctx);
		ctx.refresh();

	}
}

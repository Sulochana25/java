package com.ggktech.spring.SpringJDBC;

import org.springframework.context.ConfigurableApplicationContext;

public class SampleRefresh {

	public void logRefresh(ConfigurableApplicationContext ctx) {
		ctx.refresh();
		System.out.println("calling refresh again");
		ctx.refresh();
		ctx.refresh();

	}

}

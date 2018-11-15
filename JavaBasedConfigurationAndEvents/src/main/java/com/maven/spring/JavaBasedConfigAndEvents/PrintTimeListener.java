package com.maven.spring.JavaBasedConfigAndEvents;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintTimeListener implements ApplicationListener<PrintTimeEvent> {

	public void onApplicationEvent(PrintTimeEvent event) {
		System.out.println(event.getTime());
	}

}

package com.maven.spring.JavaBasedConfigAndEvents;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStartedEvent;

@Configuration
public class ContextStarted implements ApplicationListener<ContextStartedEvent> {

	public void onApplicationEvent(ContextStartedEvent arg0) {
		System.out.println("****Context Started*****");
	}

}

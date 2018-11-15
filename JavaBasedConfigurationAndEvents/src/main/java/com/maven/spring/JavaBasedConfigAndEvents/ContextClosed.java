package com.maven.spring.JavaBasedConfigAndEvents;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

public class ContextClosed implements ApplicationListener<ContextClosedEvent> {

	public void onApplicationEvent(ContextClosedEvent arg0) {
		System.out.println("*****Context Closed*****");
	}

}

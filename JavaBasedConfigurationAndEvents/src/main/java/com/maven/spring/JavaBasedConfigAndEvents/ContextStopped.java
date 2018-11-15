package com.maven.spring.JavaBasedConfigAndEvents;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class ContextStopped implements ApplicationListener<ContextStoppedEvent> {

	public void onApplicationEvent(ContextStoppedEvent arg0) {
		System.out.println("****Context Stopped******");

	}

}

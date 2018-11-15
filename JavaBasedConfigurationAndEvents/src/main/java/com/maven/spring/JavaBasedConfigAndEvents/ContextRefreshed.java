package com.maven.spring.JavaBasedConfigAndEvents;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ContextRefreshed implements ApplicationListener<ContextRefreshedEvent> {

	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		System.out.println("*****Context Refreshed******");

	}

}

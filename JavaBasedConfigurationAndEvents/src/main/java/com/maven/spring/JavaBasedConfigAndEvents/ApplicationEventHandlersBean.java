package com.maven.spring.JavaBasedConfigAndEvents;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationEventHandlersBean {

	@Bean
	public ContextStarted contextstarted() {
		return new ContextStarted();
	}

	@Bean
	public ContextStopped contextStopped() {
		return new ContextStopped();
	}

	@Bean
	public ContextRefreshed contextRefreshed() {
		return new ContextRefreshed();
	}

	@Bean
	public ContextClosed contextClosed() {
		return new ContextClosed();
	}
}

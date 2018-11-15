package com.maven.spring.JavaBasedConfigAndEvents;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomEventConfig {

	@Bean
	public PrintTimeEventPublisher printTimeEventPublisher() {
		return new PrintTimeEventPublisher();
	}

	@Bean
	public PrintTimeListener printTimeListener() {
		return new PrintTimeListener();
	}
}

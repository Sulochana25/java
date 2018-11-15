package com.maven.spring.JavaBasedConfigAndEvents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class PrintTimeEventPublisher implements ApplicationEventPublisherAware {

	@Autowired
	private ApplicationEventPublisher publisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public void getTime() {
		PrintTimeEvent printTime = new PrintTimeEvent(this);
		publisher.publishEvent(printTime);
	}

}

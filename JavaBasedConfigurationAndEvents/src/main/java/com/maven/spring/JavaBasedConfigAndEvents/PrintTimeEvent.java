package com.maven.spring.JavaBasedConfigAndEvents;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationEvent;

public class PrintTimeEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	public PrintTimeEvent(Object source) {
		super(source);

	}

	public Date getTime() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Date date = new Date(ts.getTime());
		return date;
	}

}

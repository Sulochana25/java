package com.maven.spring.SpringExample;

public class BeanClass {
	private String message;

	public String getMessage() {
		return message;
	}

	public void init() {
		System.out.println("BeanClass: init method");
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void printMessage() {
		System.out.println("Message for BeanClass: " + message);
	}

	public void destroy() {
		System.out.println("BeanClass: destroy method");
	}
}

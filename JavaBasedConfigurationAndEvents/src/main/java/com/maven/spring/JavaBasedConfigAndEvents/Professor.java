package com.maven.spring.JavaBasedConfigAndEvents;

public class Professor {

	private String name;

	public Professor() {
	}

	public void init() {
		System.out.println("Init method of Professor");
	}

	public void printMessage() {
		System.out.println("Professor Class");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

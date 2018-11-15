package com.maven.spring.UnderstandConstructorInjection;

public class SampleBean {

	private String message = "";

	public SampleBean(long id, String name) {
		this.message = "Executed Constructor with param(long,String)";

	}

	public SampleBean(String name, long id) {
		this.message = "Executed Constructor with param(String,long)";

	}

	public SampleBean(int id, String name) {
		this.message = "Executed Constructor with param(int,String)";

	}

	public SampleBean(String name, int id) {
		this.message = "Executed Constructor with param(String,int)";

	}

	public String printMessage() {
		return message;
	}

}

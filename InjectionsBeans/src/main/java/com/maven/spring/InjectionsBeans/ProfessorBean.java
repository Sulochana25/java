package com.maven.spring.InjectionsBeans;

import java.util.List;

public class ProfessorBean {

	private String name;
	List<String> allotedSections;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAllotedSections() {
		return allotedSections;
	}

	public void setAllotedSections(List<String> allotedSections) {
		this.allotedSections = allotedSections;
	}

}

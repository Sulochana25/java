package com.maven.spring.JavaBasedConfigAndEvents;

public class Organisation {

	private String OrgName;
	private Faculty faculty;

	public Faculty getFaculty() {
		return faculty;
	}

	public void init() {
		System.out.println("Init method of Organisation");
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public void printMessage() {
		System.out.println("Organisation class");
		faculty.printMessage();
	}

	public String getOrgName() {
		return OrgName;
	}

	public void setOrgName(String orgName) {
		OrgName = orgName;
	}

}

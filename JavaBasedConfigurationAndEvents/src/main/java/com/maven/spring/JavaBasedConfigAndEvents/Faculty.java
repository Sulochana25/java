package com.maven.spring.JavaBasedConfigAndEvents;

public class Faculty {
	private Professor professor;

	public Professor getProfessor() {
		return professor;
	}

	private String subject;

	public void init() {
		System.out.println("Init method of faculty");
	}

	public Faculty(Professor professor) {
		this.professor = professor;
	}

	public void printMessage() {

		System.out.println("Faculty class");
		professor.printMessage();
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}

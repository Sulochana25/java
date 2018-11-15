package com.maven.spring.InjectionsBeans;

public class FacultyBean {
	private String subject;
	private ProfessorBean professor;

	public FacultyBean() {

	}

	public FacultyBean(ProfessorBean professor) {

		this.professor = professor;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {

		return "Faculty assigned for " + subject + " is " + professor.getName() + " for sections "
				+ professor.getAllotedSections();
	}

}

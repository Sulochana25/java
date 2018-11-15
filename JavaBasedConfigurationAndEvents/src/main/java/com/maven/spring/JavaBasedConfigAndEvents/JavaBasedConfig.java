package com.maven.spring.JavaBasedConfigAndEvents;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaBasedConfig {

	@Bean(initMethod = "init")
	@Scope("prototype")
	public Faculty faculty() {
		Faculty faculty = new Faculty(professor());
		faculty.setSubject("Java");
		return faculty;
	}

	@Bean(initMethod = "init")
	public Professor professor() {
		Professor professor = new Professor();
		professor.setName("AR Hameo");
		return professor;
	}
}

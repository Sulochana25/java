package com.maven.spring.JavaBasedConfigAndEvents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JavaBasedConfig.class)
public class ImportJavaBasedConfig {

	@Autowired
	Faculty facultyConfig;

	@Bean(name = "org", initMethod = "init")

	public Organisation organisation() {
		Organisation organisationObj = new Organisation();
		organisationObj.setOrgName("Vignan");
		organisationObj.setFaculty(facultyConfig);
		return organisationObj;

	}

}

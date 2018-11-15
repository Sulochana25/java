package com.ggktech.spring.SpringJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jdbc.core.JdbcTemplate;

public class LogRefreshEvent implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void onApplicationEvent(ContextRefreshedEvent event) {
		jdbcTemplate.update("insert into logRefresh(message) values('Refresh event called')");
		System.out.println("Refresh event called");
	}

}

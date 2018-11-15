package com.ggktech.FormFill;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAO implements IUserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void addUser(User user) {
		String SQL = "insert into UserForms(name,email,phone,gender,country,address,languages,photo,resume,password) values(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplateObject.update(SQL, user.getName(), user.getEmail(), user.getPhone(), user.getGender(),
				user.getCountry(), user.getAddress(), user.getLanguages().toString(), user.getPhotoName(),
				user.getResumeName(), user.getPassword());
	}
}

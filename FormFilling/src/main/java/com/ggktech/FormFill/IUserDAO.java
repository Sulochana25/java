package com.ggktech.FormFill;

import javax.sql.DataSource;

public interface IUserDAO {
	public void setDataSource(DataSource ds);

	public void addUser(User user);
}

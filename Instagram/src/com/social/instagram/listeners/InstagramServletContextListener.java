package com.social.instagram.listeners;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class InstagramServletContextListener implements ServletContextListener {
	Connection con;

	public InstagramServletContextListener() {

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent sceo) {
		try {

			SQLServerDataSource ds = new SQLServerDataSource();

			ds.setUser("sa");
			ds.setPassword("Welcome@1234");
			ds.setServerName("GGKU3SER2");
			ds.setPortNumber(1433);
			ds.setDatabaseName("Sulochana");

			con = ds.getConnection();

			ServletContext context = sceo.getServletContext();
			context.setAttribute("connection", con);

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}

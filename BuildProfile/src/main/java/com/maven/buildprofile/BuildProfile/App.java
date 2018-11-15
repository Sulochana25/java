package com.maven.buildprofile.BuildProfile;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class App {
	public static void main(String[] args) {
		InputStream stream = App.class.getClassLoader().getResourceAsStream("tablename.properties");
		Properties prop = new Properties();

		try {
			prop.load(stream);
			String tableName = prop.getProperty("tablename");
			SQLServerDataSource ds = new SQLServerDataSource();

			ds.setUser("sa");
			ds.setPassword("Welcome@1234");
			ds.setServerName("GGKU3SER2");
			ds.setPortNumber(1433);
			ds.setDatabaseName("Sulochana");

			Connection con = ds.getConnection();
			Statement statement = con.createStatement();
			boolean rs = statement.execute("select * from " + tableName);
			if (rs == true) {
				System.out.println("Accessible table: " + tableName);
			} else {
				System.out.println("Cannot execute the query");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

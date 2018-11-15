package org.DAOModule;

import java.sql.Connection;
import java.sql.SQLException;

import org.CommonUtils.Constants;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class SQLConnection {

	private static SQLConnection dbInstance;
	private static Connection con;

	private SQLConnection() {

	}

	synchronized public static SQLConnection getInstance() {
		if (dbInstance == null) {
			dbInstance = new SQLConnection();
		}

		return dbInstance;
	}

	public Connection getSQLConnection() {
		if (con == null) {
			try {

				SQLServerDataSource ds = new SQLServerDataSource();

				ds.setUser(Constants.USERNAME);
				ds.setPassword(Constants.PASSWORD);
				ds.setServerName(Constants.SERVERNAME);
				ds.setPortNumber(Constants.PORTNUMBER);
				ds.setDatabaseName(Constants.DATABASENAME);

				con = ds.getConnection();

			} catch (SQLException e) {
				System.out.println("Could Not Connect to the DataBase");
			}
		}
		return con;
	}
}

package jdbc.crud.batchupdate;

import java.sql.Connection;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

class JDBCConnection {
	Connection con;

	Connection connectDriver() throws SQLException {
		try {
			SQLServerDataSource ds = new SQLServerDataSource();

			ds.setUser("sa");
			ds.setPassword("Welcome@1234");
			ds.setServerName("GGKU3SER2");
			ds.setPortNumber(1433);
			ds.setDatabaseName("Sulochana");

			con = ds.getConnection();

		} catch (SQLException e) {
			throw new SQLException();
		}

		return con;
	}
}

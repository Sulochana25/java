package jdbc.crud.batchupdate;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCConsole {
	static Connection con;

	public static void main(String[] args) throws Throwable {

		// Connect to driver and JDBC
		try {

			JDBCConnection jdbcConnection = new JDBCConnection();
			con = jdbcConnection.connectDriver();
		} catch (SQLException ex) {
			ex.getMessage();
		}

		BatchUpdate batchUpdate = new BatchUpdate();
		batchUpdate.insertUsingBatch(con);

	}
}

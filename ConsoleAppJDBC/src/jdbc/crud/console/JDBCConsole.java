package jdbc.crud.console;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCConsole {
	static Connection con;

	public static void main(String[] args) throws SQLException {

		// Connect to driver and JDBC
		try {

			JDBCConnection jdbcConnection = new JDBCConnection();
			con = jdbcConnection.connectDriver();
		} catch (SQLException ex) {
			ex.getMessage();
		}

		MenuDisplay menuDisplay = new MenuDisplay();
		menuDisplay.displayMenu(con);
	}
}

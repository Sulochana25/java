package jdbc.crud.batchupdate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class BatchUpdate {
	void insertUsingBatch(Connection con) throws Throwable, SQLException {
		BufferedReader reader = new BufferedReader(
				new FileReader("E:\\Advanced_Java\\BatchUpdate\\src\\jdbc\\crud\\batchupdate\\file.csv"));
		String line = null;
		Scanner scanner = null;

		PreparedStatement stmt = null;
		String query = "insert into UserDetails (id, name, desgination) values (?,?,?);";
		stmt = con.prepareStatement(query);
		while ((line = reader.readLine()) != null) {
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			int index = 0;
			while (scanner.hasNext()) {
				String data = scanner.next();

				if (index == 0) {
					stmt.setInt(1, Integer.parseInt(data));
				} else if (index == 1) {
					stmt.setString(2, data);
				} else {
					stmt.setString(3, data);
					stmt.addBatch();
				}
				index++;
			}
		}
		stmt.executeBatch();

		System.out.println("Inserted Successfully");
		reader.close();
	}
}

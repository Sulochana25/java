package jdbc.crud.console;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CrudOperations {
	Scanner scan = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	Connection con = null;
	ResultSet resultSet = null;
	ResultSetMetaData resultSetMetaData = null;
	String table = null;
	List<String> columnNames;
	List<String> dataTypes;

	CrudOperations(Connection con) {
		this.con = con;
		scan = new Scanner(System.in);

		columnNames = new ArrayList<String>();
		dataTypes = new ArrayList<String>();
	}

	void displayTables() throws SQLException {
		try {
			statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery("Select * from sys.Tables");

			if (resultSet != null) {
				System.out.println("Available Tables are:");

				int rowCount = 0;
				while (resultSet.next()) {
					System.out.println(++rowCount + ". " + resultSet.getString(1));
				}

				selectTable(rowCount);

			} else {
				System.out.println("No tables in the database");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void selectTable(int rowCount) throws SQLException {
		System.out.println("Select Table(Number):");

		int tableNum;
		tableNum = scan.nextInt();

		resultSet.absolute(tableNum);
		table = resultSet.getString(1);

		tableMetaData();

		System.out.println();
	}

	void tableMetaData() throws SQLException {
		resultSet = statement.executeQuery("Select top 1 * from " + table);
		resultSetMetaData = resultSet.getMetaData();

		System.out.println("Available Columns in Table " + table);
		int columns = resultSetMetaData.getColumnCount();
		int column = 1;
		while (column <= columns) {
			columnNames.add(resultSetMetaData.getColumnName(column));
			dataTypes.add(resultSetMetaData.getColumnTypeName(column));
			System.out.println(
					resultSetMetaData.getColumnName(column) + "\t" + resultSetMetaData.getColumnTypeName(column));
			column++;
		}
	}

	void createTable() throws SQLException {

		scan.nextLine();

		String sql = "create table ";
		System.out.println("Enter table name:");
		sql += scan.nextLine();
		sql += " (";

		System.out.println("Enter column Name:");
		sql += scan.nextLine();
		sql += " ";

		System.out.println("Enter column Type:");
		sql += scan.nextLine();
		sql += " ";

		System.out.println("Enter 1 to add another column else 0");
		while (scan.nextInt() == 1) {
			scan.nextLine();

			sql += ", ";
			System.out.println("Enter column Name:");
			sql += scan.nextLine();
			sql += " ";

			System.out.println("Enter column Type:");
			sql += scan.nextLine();
			sql += " ";

			System.out.println("Enter 1 to add another column else 0");
		}
		sql += ")";

		statement.execute(sql);

		System.out.println("Table created successfully!!!!!!");

		System.out.println();
	}

	void readData() throws SQLException {
		if (table == null) {
			throw new SQLException("Table is Null/Not Found");
		}
		// read data from table
		resultSet = statement.executeQuery("select * from " + table);

		System.out.println("Data in " + table);

		for (String column : columnNames) {
			System.out.print(column + "\t");
		}

		System.out.println();

		while (resultSet.next()) {
			for (String column : columnNames) {
				System.out.print(resultSet.getString(column) + "\t");
			}
			System.out.println();
		}

		System.out.println();
	}

	void insertData() throws SQLException {
		if (table == null) {
			throw new SQLException("Table is Null/Not Found");
		}

		int colCount = columnNames.size();

		String sql;
		sql = "insert into " + table + " values(?";
		for (int col = 1; col < colCount; col++) {
			sql += ",? ";
		}
		sql += ")";

		preparedStatement = con.prepareStatement(sql);
		for (int col = 1; col <= colCount; col++) {
			System.out
					.println("Enter Value for " + columnNames.get(col - 1) + "(type: " + dataTypes.get(col - 1) + ")");
			if ("int".equals(dataTypes.get(col - 1))) {
				preparedStatement.setInt(col, scan.nextInt());
				scan.nextLine();
			} else if ("varchar".equals(dataTypes.get(col - 1))) {
				preparedStatement.setString(col, scan.nextLine());
			}

		}

		preparedStatement.execute();
		System.out.println("Record inserted!!!!!\n");
	}

	void updateData() throws SQLException {
		if (table == null) {
			throw new SQLException("Table is Null/Not Found");
		}

		System.out.println("Available coulmns:");

		int start = 1;
		for (String column : columnNames) {
			System.out.println(start + ". " + column);
			start++;
		}
		System.out.println();

		System.out.println("Enter the column Number as constraint:");
		int whereColIndex = scan.nextInt() - 1;
		String whereColumnName = columnNames.get(whereColIndex);

		System.out.println("Enter the column Number to be changed:");
		int toColIndex = scan.nextInt() - 1;
		String toColumnName = columnNames.get(toColIndex);

		String sql = "update " + table + "set " + toColumnName + " =(?) where " + whereColumnName + "=('?')";
		preparedStatement = con.prepareStatement(sql);

		if ("int".equals(dataTypes.get(whereColIndex))) {
			System.out.println("Enter " + whereColumnName + "(int):");
			preparedStatement.setInt(2, scan.nextInt());
			scan.nextLine();
		} else if ("varchar".equals(dataTypes.get(whereColIndex))) {
			System.out.println("Enter " + whereColumnName + "(varchar):");
			preparedStatement.setString(2, scan.nextLine());
		}

		if ("int".equals(dataTypes.get(toColIndex))) {
			System.out.println("Enter " + toColumnName + "(int):");
			preparedStatement.setInt(1, scan.nextInt());
			scan.nextLine();
		} else if ("varchar".equals(dataTypes.get(toColIndex))) {
			System.out.println("Enter " + toColumnName + "(varchar):");
			preparedStatement.setString(1, scan.nextLine());
		}

		int rowsAffected = preparedStatement.executeUpdate();
		System.out.println(rowsAffected + " Records updated!!!!!!\n");
	}

	void deleteData() throws SQLException {
		if (table == null) {
			throw new SQLException("Table is Null/Not Found");
		}

		System.out.println("Available coulmns to compare");

		int start = 1;
		for (String column : columnNames) {
			System.out.println(start + ". " + column);
			start++;
		}
		System.out.println();

		System.out.println("Enter the column Number as constraint:");
		int colIndex = scan.nextInt() - 1;
		String columnName = columnNames.get(colIndex);

		String sql = "delete from " + table + " where " + columnName + "=(?)";
		preparedStatement = con.prepareStatement(sql);

		if ("int".equals(dataTypes.get(colIndex))) {
			System.out.println("Enter " + columnName + "(int):");
			preparedStatement.setInt(colIndex + 1, scan.nextInt());
			scan.nextLine();
		} else if ("varchar".equals(dataTypes.get(colIndex))) {
			System.out.println("Enter " + columnName + "(varchar):");
			preparedStatement.setString(colIndex + 1, scan.nextLine());
		}

		int rowsAffected = preparedStatement.executeUpdate();
		System.out.println(rowsAffected + " Records deleted!!!!!!\n");
	}

}

package jdbc.crud.console;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

class MenuDisplay {
	Scanner scan;
	CrudOperations crudOperations;
	int option;

	MenuDisplay() {
		scan = new Scanner(System.in);
	}

	void displayMenu(Connection con) throws SQLException {
		crudOperations = new CrudOperations(con);
		while (true) {
			System.out.println("<--OPERATIONS-->");
			System.out.println("0.View Tables\n" + "1.Create\n" + "2.Insert\n" + "3.Read\n" + "4.Update\n"
					+ "5.Delete\n" + "6.close connnection");

			System.out.println("Choose an option:");

			option = scan.nextInt();

			switch (option) {
			case 0:
				crudOperations.displayTables();
				break;
			case 1:
				crudOperations.createTable();
				break;

			case 2:
				crudOperations.insertData();
				break;

			case 3:
				crudOperations.readData();
				break;

			case 4:
				crudOperations.updateData();
				break;

			case 5:
				crudOperations.deleteData();
				break;

			case 6:
				con.close();
				System.out.println("Closing the connection.....\nDone");
				System.exit(0);

			default:
				System.out.println("Choose correct option!!!");
				break;

			}
		}
	}

}

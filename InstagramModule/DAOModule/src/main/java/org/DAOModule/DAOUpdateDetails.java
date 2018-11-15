package org.DAOModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.CommonUtils.UserDetailsBean;

public class DAOUpdateDetails {
	private static DAOUpdateDetails instance;

	private DAOUpdateDetails() {

	}

	synchronized public static DAOUpdateDetails getInstance() {

		if (instance == null) {
			instance = new DAOUpdateDetails();
		}

		return instance;
	}

	public int updateDetails(int userid, UserDetailsBean userDetailsBean) {

		String fileName = userDetailsBean.getDisplayPicture();
		String emailid = userDetailsBean.getEmailid();
		String password = userDetailsBean.getPassword();
		String firstname = userDetailsBean.getFirstName();
		String lastname = userDetailsBean.getLastName();
		String country = userDetailsBean.getCountry();

		try {
			Connection con = SQLConnection.getInstance().getSQLConnection();

			PreparedStatement preparedStatement = null;
			PreparedStatement updateStatement = con.prepareStatement(
					" update SnapGGkUsers SET emailid=?,password = ?,firstname=?,lastname=? WHERE id = ?");
			updateStatement.setString(1, emailid);
			updateStatement.setString(2, password);
			updateStatement.setString(3, firstname);
			updateStatement.setString(4, lastname);
			updateStatement.setInt(5, userid);

			if (fileName == "" || fileName == null) {
				preparedStatement = con.prepareStatement(
						" update userDetails SET emailid=?,password = ?,firstname=?,lastname=?,country=? WHERE userid = ?");

				preparedStatement.setInt(6, userid);
			} else {
				preparedStatement = con.prepareStatement(
						" update userDetails SET emailid=?,password = ?,firstname=?,lastname=?,country=?,displayPicture=? WHERE userid = ?");

				preparedStatement.setString(6, fileName);
				preparedStatement.setInt(7, userid);
			}
			preparedStatement.setString(1, emailid);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, firstname);
			preparedStatement.setString(4, lastname);
			preparedStatement.setString(5, country);

			updateStatement.executeUpdate();
			preparedStatement.executeUpdate();

			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

}

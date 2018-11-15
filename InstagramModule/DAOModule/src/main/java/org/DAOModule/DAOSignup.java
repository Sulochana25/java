package org.DAOModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.CommonUtils.SignUpBean;

public class DAOSignup {
	private static DAOSignup instance;

	private DAOSignup() {

	}

	synchronized public static DAOSignup getInstance() {

		if (instance == null) {
			instance = new DAOSignup();
		}

		return instance;
	}

	// return -1 for exception
	public int dbRegisterUser(SignUpBean signupBean) {

		ResultSet rs = null;
		PreparedStatement preparedStatement;

		try {
			Connection con = SQLConnection.getInstance().getSQLConnection();

			preparedStatement = con.prepareStatement("insert into SnapGGKUsers values(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, signupBean.getFirstName());
			preparedStatement.setString(2, signupBean.getLastName());
			preparedStatement.setString(3, signupBean.getEmailId());
			preparedStatement.setString(4, signupBean.getPassword());
			preparedStatement.executeUpdate();

			rs = preparedStatement.getGeneratedKeys();
			int userid = 0;
			if (rs != null && rs.next()) {
				userid = rs.getInt(1);
			}

			preparedStatement = con.prepareStatement(
					"insert into userDetails(userid,emailid,password,displayPicture,firstname,lastname,country) values(?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, userid);
			preparedStatement.setString(2, signupBean.getEmailId());
			preparedStatement.setString(3, signupBean.getPassword());
			preparedStatement.setString(4, "3.jpg");
			preparedStatement.setString(5, signupBean.getFirstName());
			preparedStatement.setString(6, signupBean.getLastName());
			preparedStatement.setString(7, "United States");

			int isExecuted = preparedStatement.executeUpdate();

			if (isExecuted == 1) {
				return 1;
			}

		} catch (SQLException e) {

			System.out.println("Query could not be executed" + e);
			return -1;
		}

		return 0;
	}

}

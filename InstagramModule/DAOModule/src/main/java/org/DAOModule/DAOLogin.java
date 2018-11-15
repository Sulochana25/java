package org.DAOModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.CommonUtils.LoginBean;

public class DAOLogin {
	private static DAOLogin instance;

	private DAOLogin() {

	}

	synchronized public static DAOLogin getInstance() {

		if (instance == null) {
			instance = new DAOLogin();
		}

		return instance;
	}

	public int dbGetUser(LoginBean loginBean) {

		ResultSet rs = null;
		PreparedStatement preparedStatement;

		try {
			Connection con = SQLConnection.getInstance().getSQLConnection();
			preparedStatement = con
					.prepareStatement("select id,emailid,password from SnapGGKUsers where emailid=? and password=?");
			preparedStatement.setString(1, loginBean.getEmailid());
			preparedStatement.setString(2, loginBean.getPassword());

			rs = preparedStatement.executeQuery();

			int userid = 0;
			if (rs != null && rs.next()) {
				userid = rs.getInt(1);
				return userid;
			}

		} catch (SQLException e) {
			System.out.println("DAO Login: " + e);
			return -2;
		}

		return -1;
	}
}

package org.DAOModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.CommonUtils.NewPostBean;

public class DAOUploadUserPost {
	private static DAOUploadUserPost instance;

	private DAOUploadUserPost() {

	}

	synchronized public static DAOUploadUserPost getInstance() {

		if (instance == null) {
			instance = new DAOUploadUserPost();
		}

		return instance;
	}

	public int uploadPost(int userid, NewPostBean newPostBean) {

		try {
			Connection con = SQLConnection.getInstance().getSQLConnection();

			String description = newPostBean.getDescription();
			String picture = newPostBean.getPicture();

			PreparedStatement preparedStatement = con
					.prepareStatement("insert into posted_pictures(userid,postdescription,pictureblob) values(?,?,?)");

			preparedStatement.setInt(1, userid);
			preparedStatement.setString(2, description);
			preparedStatement.setString(3, picture);
			preparedStatement.executeUpdate();

			return 1;

		} catch (SQLException e) {
			System.out.println(e);
			return -1;
		}
	}

}

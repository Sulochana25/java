package org.DAOModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.CommonUtils.Constants;
import org.CommonUtils.NewPostBean;

public class DAUserPosts {
	private static DAUserPosts instance;

	private DAUserPosts() {

	}

	synchronized public static DAUserPosts getInstance() {

		if (instance == null) {
			instance = new DAUserPosts();
		}

		return instance;
	}

	public List<NewPostBean> getUserPosts(int userid) {
		ResultSet rs = null;
		PreparedStatement preparedStatement;
		List<NewPostBean> posts = new ArrayList<NewPostBean>();

		try {
			Connection con = SQLConnection.getInstance().getSQLConnection();

			preparedStatement = con
					.prepareStatement("Select pictureblob,postdescription from posted_pictures where userid=(?)");
			preparedStatement.setInt(1, userid);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				NewPostBean newPostBean = new NewPostBean();
				// NewPostBean newPostBean = NewPostBean.getInstance();
				newPostBean.setPicture(rs.getString(Constants.PICTUREBLOB));
				newPostBean.setDescription(rs.getString(Constants.PICTURE_DESCRIPTION));
				posts.add(newPostBean);
			}

		} catch (Exception e) {
			System.out.println("Posts posted by the user cannot be retrieved");
			return null;
		}

		return posts;
	}

	public List<String> getnameAndDp(int userid) {
		ResultSet rs = null;
		PreparedStatement preparedStatement;

		List<String> userDetails = new ArrayList<String>();

		try {
			Connection con = SQLConnection.getInstance().getSQLConnection();

			preparedStatement = con.prepareStatement(
					"Select firstname,lastname,emailid,country,password,displayPicture from userDetails where userid=(?)");
			preparedStatement.setInt(1, userid);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				userDetails.add(rs.getString(Constants.FIRSTNAME));
				userDetails.add(rs.getString(Constants.LASTNAME));
				userDetails.add(rs.getString(Constants.EMAILID));
				userDetails.add(rs.getString(Constants.COUNTRY));
				userDetails.add(rs.getString(Constants.USERPASSWORD));
				userDetails.add(rs.getString(Constants.DISPLAY_PICTURE));
			}

		} catch (Exception e) {
			System.out.println("getnameAndDp: " + e);
			return null;
		}

		return userDetails;
	}
}

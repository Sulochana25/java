package org.ServiceModule;

import org.CommonUtils.NewPostBean;
import org.DAOModule.DAOUploadUserPost;

public class ServiceUploadUserPost {
	private static ServiceUploadUserPost instance;

	private ServiceUploadUserPost() {
	}

	synchronized public static ServiceUploadUserPost getInstance() {

		if (instance == null) {
			instance = new ServiceUploadUserPost();
		}
		return instance;
	}

	public int uploadPost(int userid, NewPostBean newPostBean) {
		return DAOUploadUserPost.getInstance().uploadPost(userid, newPostBean);
	}

}

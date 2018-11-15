package org.ServiceModule;

import java.util.List;

import org.CommonUtils.NewPostBean;
import org.DAOModule.DAUserPosts;

public class ServiceUserProfile {
	private static ServiceUserProfile instance;

	private ServiceUserProfile() {
	}

	synchronized public static ServiceUserProfile getInstance() {

		if (instance == null) {
			instance = new ServiceUserProfile();
		}
		return instance;
	}

	public List<NewPostBean> getUserInformation(int userid) {
		return DAUserPosts.getInstance().getUserPosts(userid);
	}

	public List<String> getUserDetails(int userid) {
		return DAUserPosts.getInstance().getnameAndDp(userid);

	}
}

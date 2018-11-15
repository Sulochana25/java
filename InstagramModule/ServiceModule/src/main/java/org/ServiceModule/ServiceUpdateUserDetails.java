package org.ServiceModule;

import org.CommonUtils.UserDetailsBean;
import org.DAOModule.DAOUpdateDetails;

public class ServiceUpdateUserDetails {
	private static ServiceUpdateUserDetails instance;

	private ServiceUpdateUserDetails() {
	}

	synchronized public static ServiceUpdateUserDetails getInstance() {

		if (instance == null) {
			instance = new ServiceUpdateUserDetails();
		}
		return instance;
	}

	public int updateUserDetails(int userid, UserDetailsBean userDetailsBean) {
		return DAOUpdateDetails.getInstance().updateDetails(userid, userDetailsBean);
	}

}

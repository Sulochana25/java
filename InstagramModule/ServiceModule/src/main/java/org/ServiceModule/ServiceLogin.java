package org.ServiceModule;

import org.CommonUtils.LoginBean;
import org.DAOModule.DAOLogin;

public class ServiceLogin {
	private static ServiceLogin instance;

	private ServiceLogin() {

	}

	synchronized public static ServiceLogin getInstance() {

		if (instance == null) {
			instance = new ServiceLogin();
		}
		return instance;
	}

	public int getUser(LoginBean loginBean) {
		int rs = -1;
		rs = DAOLogin.getInstance().dbGetUser(loginBean);

		return rs;
	}

}

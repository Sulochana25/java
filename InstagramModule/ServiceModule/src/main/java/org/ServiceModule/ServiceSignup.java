package org.ServiceModule;

import org.CommonUtils.SignUpBean;
import org.DAOModule.DAOSignup;

public class ServiceSignup {
	private static ServiceSignup instance;

	private ServiceSignup() {
	}

	synchronized public static ServiceSignup getInstance() {

		if (instance == null) {
			instance = new ServiceSignup();
		}
		return instance;
	}

	public int RegisterUser(SignUpBean signupBean) {
		int rs = 0;
		rs = DAOSignup.getInstance().dbRegisterUser(signupBean);

		return rs;
	}
}

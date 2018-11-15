package org.CommonUtils;

public class SetBeanValues {
	public static Object setBeanValue(UserDetailsBean userDetailsBean, String firstName, String lastName,
			String emailid, String password, String displayPicture, String country) {

		userDetailsBean.setFirstName(firstName);
		userDetailsBean.setLastName(lastName);
		userDetailsBean.setEmailid(emailid);
		userDetailsBean.setPassword(password);
		userDetailsBean.setCountry(country);

		if (displayPicture != "" && displayPicture != null) {
			userDetailsBean.setDisplayPicture(displayPicture);
		}

		return userDetailsBean;
	}
}

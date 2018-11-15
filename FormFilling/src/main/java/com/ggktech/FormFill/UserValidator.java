package com.ggktech.FormFill;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "phone.required");
		ValidationUtils.rejectIfEmpty(errors, "gender", "gender.required");
		ValidationUtils.rejectIfEmpty(errors, "country", "country.required");

		if ("NONE".equals(user.getCountry())) {
			errors.rejectValue("country", "required.country");
		}

	}
}

package com.music.validators;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.music.entities.User;

@Component
public class RegisterValidator implements Validator{

	@Autowired
	private MessageSource messageSource;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				messageSource.getMessage("username.empty", null, Locale.ENGLISH));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress",
				messageSource.getMessage("emailAddress.empty", null, Locale.ENGLISH));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber",
				messageSource.getMessage("number.empty", null, Locale.ENGLISH));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				messageSource.getMessage("firstname.empty", null, Locale.ENGLISH));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
				messageSource.getMessage("lastname.empty", null, Locale.ENGLISH));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth",
				messageSource.getMessage("dob.empty", null, Locale.ENGLISH));
	}

}

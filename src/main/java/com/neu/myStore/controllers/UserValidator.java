package com.neu.myStore.controllers;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.myStore.pojo.User;

import org.springframework.validation.ValidationUtils;


@Component
public class UserValidator implements Validator {

	
	@Override
	public boolean supports(Class aClass)
    {
        return aClass.equals(User.class);
    }
	
	
	@Override
    public void validate(Object obj, Errors errors)
    {
        User user = (User) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.invalid.user", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.address", "Address Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.emailId", "error.invalid.email.emailId", "Email Required");
       // ValidationUtils.rejectSpecialChars(errors, "email.emailId", "error.invalid.email.emailId", "Email Required");
        
    }
    
	

}

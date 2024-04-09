package com.smartlock.Business.validators;

import org.apache.commons.validator.routines.EmailValidator;


public class ValidateUser {

    public static boolean validateEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

}

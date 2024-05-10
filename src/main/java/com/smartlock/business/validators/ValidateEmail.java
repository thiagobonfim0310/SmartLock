package com.smartlock.business.validators;

import org.apache.commons.validator.routines.EmailValidator;

import com.smartlock.business.entities.User;

public class ValidateEmail{

    private EmailValidator emailValidator;

    public ValidateEmail() {
        this.emailValidator = EmailValidator.getInstance();
    }

    public boolean isValidEmail(User user) {
        return emailValidator.isValid(user.getEmail());
    }
}

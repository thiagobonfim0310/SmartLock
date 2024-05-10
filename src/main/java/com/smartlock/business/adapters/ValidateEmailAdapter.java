package com.smartlock.business.adapters;

import org.apache.commons.validator.routines.EmailValidator;

import com.smartlock.business.validators.ValidateEmail;

public class ValidateEmailAdapter implements ValidateEmail {

    private EmailValidator emailValidator;

    public ValidateEmailAdapter() {
        this.emailValidator = EmailValidator.getInstance();
    }

    @Override
    public boolean isValidEmail(String email) {
        return emailValidator.isValid(email);
    }
}

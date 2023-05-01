package com.zorii.epam.taxi.app.utils;

import com.zorii.epam.taxi.app.exception.*;

import static com.zorii.epam.taxi.app.exception.constant.ValidationErrorMessages.*;
import static com.zorii.epam.taxi.app.utils.constant.ValidationPatterns.*;

public class Validator {
    private static void validate(String toValidate, String pattern, String errorMessage) throws InvalidFormatException {
        if (toValidate == null || !toValidate.matches(pattern)) {
            throw new InvalidFormatException(errorMessage);
        }
    }

    public static void validateLogin(String login) throws InvalidFormatException {
        validate(login, LOGIN_PATTERN, INVALID_LOGIN_MESSAGE);
    }

    public static void validatePassword(String password) throws InvalidFormatException {
        validate(password, PASSWORD_PATTERN, INVALID_PASSWORD_MESSAGE);
    }

    public static void validateName(String name) throws InvalidFormatException {
        System.out.println(name);
        validate(name, NAME_PATTERN, INVALID_NAME_MESSAGE);
    }

    public static void validateEmail(String email) throws InvalidFormatException {
        validate(email, EMAIL_PATTERN, INVALID_EMAIL_MESSAGE);
    }

    public static void validatePasswordRepeating(String password, String repeatedPassword) throws PasswordRepeatingException {
        if (!password.equals(repeatedPassword)) {
            throw new PasswordRepeatingException();
        }
    }

    public static void validatePositiveInt(String value) throws ServiceException {
//        try {
//            int result = Integer.parseInt(value);
//            if (result < 0) {
//                throw new NumberFormatException();
//            }
//        } catch (NumberFormatException e) {
//            throw new ServiceException();
//        }
    }
}

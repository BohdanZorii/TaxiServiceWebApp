package com.zorii.epam.taxi.app.utils;

import com.zorii.epam.taxi.app.exception.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;
import static com.zorii.epam.taxi.app.exception.constant.ValidationErrorMessages.*;
import static com.zorii.epam.taxi.app.utils.Validator.*;

public class ValidatorTesting {

    @ParameterizedTest
    @ValueSource(strings = {"lalo", "nagibator228", "AnOtHeR1LegAlNAME"})
    void testValidateCorrectLogin(String login){
        assertDoesNotThrow(()->validateLogin(login));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Лало", "nagibator_228", "1214", "SomethingWayTooLongToBeALoginString"})
    void testValidateIncorrectLogin(String login){
        Exception e = assertThrows(InvalidFormatException.class, ()->validateLogin(login));
        assertEquals(e.getMessage(), INVALID_LOGIN_MESSAGE);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testValidateEmptyLogin(String login){
        Exception e = assertThrows(InvalidFormatException.class, ()->validateLogin(login));
        assertEquals(e.getMessage(), INVALID_LOGIN_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Po6in_hood", "SomePassword90", "134AnotherExample134"})
    void testValidateCorrectPassword(String password){
        assertDoesNotThrow(()->validatePassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ONLY_UPPER_CASE", "only_lower_case", "OnlyLetters", "ab",
            "SomethingWayTooLongToBeAPasswordString"})
    void testValidateIncorrectPassword(String password){
        Exception e = assertThrows(InvalidFormatException.class, ()->validatePassword(password));
        assertEquals(e.getMessage(), INVALID_PASSWORD_MESSAGE);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testValidateEmptyPassword(String password){
        Exception e = assertThrows(InvalidFormatException.class, ()->validatePassword(password));
        assertEquals(e.getMessage(), INVALID_PASSWORD_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Mike", "В'ячеслав", "Стрибайло-Леськів"})
    void testValidateCorrectName(String name){
        assertDoesNotThrow(()->validateName(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Mike123", "Осып", "SomethingWayTooLongToBeNameString"})
    void testValidateIncorrectName(String name){
        Exception e = assertThrows(InvalidFormatException.class, ()->validateName(name));
        assertEquals(e.getMessage(), INVALID_NAME_MESSAGE);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testValidateEmptyName(String name){
        Exception e = assertThrows(InvalidFormatException.class, ()->validateName(name));
        assertEquals(e.getMessage(), INVALID_NAME_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"bohdanzorii@epam.com", "bohdan.zorii@epam.com", "bohdan@epam.com.ua"})
    void testValidateCorrectEmail(String email){
        assertDoesNotThrow(()->validateEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"bohdan@epam", "bohdan.epam", "@bohdan.epam.com"})
    void testValidateIncorrectEmail(String email){
        Exception e = assertThrows(InvalidFormatException.class, ()->validateEmail(email));
        assertEquals(e.getMessage(), INVALID_EMAIL_MESSAGE);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testValidateEmptyEmail(String email){
        Exception e = assertThrows(InvalidFormatException.class, ()->validateEmail(email));
        assertEquals(e.getMessage(), INVALID_EMAIL_MESSAGE);
    }

    @Test
    void testValidatePasswordRepeating(){
        String password1="password1",
                password2="password2",
                password3="password3";

        assertDoesNotThrow(()->validatePasswordRepeating(password1, password1));
        assertDoesNotThrow(()->validatePasswordRepeating(password2, password2));
        assertDoesNotThrow(()->validatePasswordRepeating(password3, password3));

        assertThrows(PasswordRepeatingException.class, ()->validatePasswordRepeating(password1, password2));
        assertThrows(PasswordRepeatingException.class, ()->validatePasswordRepeating(password2, password3));
    }

}

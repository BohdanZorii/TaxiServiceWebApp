package com.zorii.epam.taxi.app.utils;

import com.password4j.Password;
import com.zorii.epam.taxi.app.exception.IncorrectPasswordException;

public class PasswordHasher {
    public static String encrypt(String password){
        return Password.hash(password).withScrypt().getResult();
    }

    public static void verify(String password, String hash) throws IncorrectPasswordException {
        if(!Password.check(password, hash).withScrypt())
            throw new IncorrectPasswordException();
    }

}

package com.zorii.epam.taxi.app.utils;

import com.zorii.epam.taxi.app.exception.IncorrectPasswordException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static com.zorii.epam.taxi.app.utils.PasswordHasher.*;

public class PasswordHasherTest {

    @ParameterizedTest
    @ValueSource(strings = {"Po6in_hood", "SomePassword90", "134AnotherExample134"})
    void testHashDontEqualsPassword(String password){
        String hash = encrypt(password);
        assertNotEquals(password, hash);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Po6in_hood", "SomePassword90", "134AnotherExample134"})
    void testCorrectDecryption(String password){
        String hash = encrypt(password);
        assertDoesNotThrow(()->verify(password, hash));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Po6in_hood", "SomePassword90", "134AnotherExample134"})
    void testIncorrectDecryption(String password){
        assertThrows(IncorrectPasswordException.class, ()->verify(password, encrypt("somethingElse")));
    }
}

package com.zorii.epam.taxi.app.exception;

public class UserSigningInException extends ServiceException{
    public UserSigningInException(Throwable cause) {
        super(cause);
    }

    public UserSigningInException(String message) {
        super(message);
    }

    public UserSigningInException() {
        super();
    }
}

package com.zorii.epam.taxi.app.utils.constant;

public class ValidationPatterns {
    public static final String LOGIN_PATTERN = "^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\\d.-]{3,20}$";
    public static final String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$";
    public static final String NAME_PATTERN = "^[A-Za-zА-ЩЬЮЯҐІЇЄа-щьюяґіїє'\\-]{1,20}";
    public static final String EMAIL_PATTERN = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
}

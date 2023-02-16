package com.zorii.epam.taxi.app.entity.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int balance;
    private int amountSpent;
    private Role role;
}

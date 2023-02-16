package com.zorii.epam.taxi.app.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private final String role;
}

package com.zorii.epam.taxi.app.entity.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Role {
    private int id;
    private String name;
}

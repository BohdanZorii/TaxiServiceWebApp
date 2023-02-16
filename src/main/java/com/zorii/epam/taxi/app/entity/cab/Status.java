package com.zorii.epam.taxi.app.entity.cab;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Status {
    private int id;
    private String name;
}

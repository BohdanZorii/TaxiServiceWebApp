package com.zorii.epam.taxi.app.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {
    private int id;
    private String name;
}

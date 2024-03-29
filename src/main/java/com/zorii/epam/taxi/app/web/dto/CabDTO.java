package com.zorii.epam.taxi.app.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CabDTO {
    private int id;
    private int capacity;
    private CategoryDTO category;
    private String status;
}

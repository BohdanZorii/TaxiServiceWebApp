package com.zorii.epam.taxi.app.entity.cab;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cab {
    private int id;
    private int capacity;
    private Category category;
    private Status status;

}

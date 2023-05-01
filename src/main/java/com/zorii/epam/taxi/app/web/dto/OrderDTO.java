package com.zorii.epam.taxi.app.web.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class OrderDTO {
    private int id;
    private String departureAddress;
    private String destinationAddress;
    private String numOfPassengers;
    private CategoryDTO cabCategory;
    private int cost;
    private UserDTO client;
    private String distance;
    private Date date;
}

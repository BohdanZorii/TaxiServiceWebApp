package com.zorii.epam.taxi.app.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {
    private int id;
    private String departureAddress;
    private String destinationAddress;
    private String numOfPassengers;
    private String cabCategory;
    private int cost;
    private UserDTO client;
    private String distance;
}

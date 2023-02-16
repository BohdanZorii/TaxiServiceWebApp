package com.zorii.epam.taxi.app.entity.order;

import java.sql.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private int id;
    private String departureAddress;
    private String destinationAddress;
    private int numOfPassengers;
    private int cost;
    private Date dateOfOrder;
    private int cabId;
    private String clientLogin;
    private int distance;
}

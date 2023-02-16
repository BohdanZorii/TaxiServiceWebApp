package com.zorii.epam.taxi.app.dao;

import com.zorii.epam.taxi.app.entity.order.Order;
import com.zorii.epam.taxi.app.exception.DAOException;

import java.util.List;

public interface OrderDAO {
    void add(Order order) throws DAOException;
    Order get(int id) throws DAOException;
    List<Order> getOrdersByConditions(String postfixQuery) throws DAOException;
    int calculateTotalRecordsNum() throws DAOException;
}

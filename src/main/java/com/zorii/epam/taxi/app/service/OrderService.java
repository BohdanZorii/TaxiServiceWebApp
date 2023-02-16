package com.zorii.epam.taxi.app.service;

import com.zorii.epam.taxi.app.dao.OrderDAO;
import com.zorii.epam.taxi.app.dao.mysql.utils.MySQLQueryBuilder;
import com.zorii.epam.taxi.app.dao.utils.DAOFactory;
import com.zorii.epam.taxi.app.dao.utils.DataSourceManager;
import com.zorii.epam.taxi.app.utils.QueryBuilder;
import com.zorii.epam.taxi.app.entity.cab.Cab;
import com.zorii.epam.taxi.app.entity.order.Order;
import com.zorii.epam.taxi.app.entity.user.User;
import com.zorii.epam.taxi.app.exception.DAOException;
import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.web.dto.OrderDTO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static com.zorii.epam.taxi.app.service.CabService.*;
import static com.zorii.epam.taxi.app.service.constant.BusinessConstants.*;
import static com.zorii.epam.taxi.app.utils.Convertor.*;
import static com.zorii.epam.taxi.app.utils.Validator.*;
import static com.zorii.epam.taxi.app.utils.Paginator.*;

public class OrderService {
    private static OrderDAO orderDAO;

    static {
        orderDAO = DAOFactory.getInstance(DataSourceManager.getDataSource()).getOrderDAO();
    }

    public static void addOrder(OrderDTO orderDTO) throws ServiceException {
        validatePositiveInt(orderDTO.getNumOfPassengers());
        validatePositiveInt(orderDTO.getDistance());

        Order order = convertDTOtoOrder(orderDTO);
        order.setDateOfOrder(Date.valueOf(LocalDate.now()));

        //to refactor
        Cab cab = getSuitableCabs(orderDTO).get(0);
        cab.setStatus(getStatus("ON ROUTE"));
        updateStatus(cab);
        order.setCabId(cab.getId());

        try {
            orderDAO.add(order);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public static int getTotalRecordsNum() throws ServiceException {
        try {
            return orderDAO.calculateTotalRecordsNum();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public static List<Order> getOrdersByConditions(String postfixQuery) throws ServiceException {

        try {
            return orderDAO.getOrdersByConditions(postfixQuery);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public static int calculateOrderCost(OrderDTO orderDTO) throws ServiceException {
        validatePositiveInt(orderDTO.getNumOfPassengers());
        ;

        User client = convertDTOtoUser(orderDTO.getClient());

        double tariff = CabService.getCategory(orderDTO.getCabCategory()).getTariff();
        int distance = Integer.valueOf(orderDTO.getDistance());
        double discount = calculateDiscount(client.getAmountSpent());

        return (int) Math.round(distance * COST_PER_KM * tariff * (100 - discount));
    }

    private static double calculateDiscount(int amountSpent) {
        if (amountSpent < 100) {
            return 0.02;
        } else if (amountSpent >= 100 && amountSpent <= 500) {
            return 0.05;
        } else if (amountSpent > 700 && amountSpent < 1500) {
            return 0.1;
        } else if (amountSpent >= 1500) {
            return 0.2;
        } else {
            return 0;
        }
    }
}

package com.zorii.epam.taxi.app.dao.constant;

public class SQLQueries {
    //ADD
    public static final String ADD_USER = "INSERT INTO taxi_service.user (login, password, first_name, last_name," +
            "email, balance, amount_spent, role_id) VALUES(?,?,?,?,?,?,?,?)";
    public static final String ADD_ORDER = "INSERT INTO taxi_service.order (departure_address, destination_address," +
            " num_of_passengers, cost_of_order, date_of_order, cab_id, client_login, distance) VALUES(?,?,?,?,?,?,?,?)";
    //GET
    public static final String GET_USER = "SELECT * FROM `user` u" +
            " JOIN `role` r ON r.role_id=u.role_id" +
            "  WHERE u.login=?";
    public static final String GET_CAB = "SELECT * FROM `cab` c " +
            " JOIN `status` s ON s.status_id=c.status_id" +
            " JOIN `category` cat ON cat.category_id=c.category_id " +
            "WHERE c.id=?";
    public static final String GET_CABS = "SELECT * FROM  cab " +
            "JOIN status ON status.status_id=cab.status_id" +
            "  JOIN category ON category.category_id=cab.category_id" +
            " WHERE cab.capacity>=? AND cab.category_id=? AND cab.status_id=1";
    public static final String GET_CABS_ALTER = "SELECT * FROM taxi_service.cab WHERE capacity>=?";

    public static final String GET_ORDER = "SELECT * FROM taxi_service.order WHERE id=?";
    public static final String GET_ORDERS = "SELECT * FROM taxi_service.order ";
    public static final String GET_ROLES = "SELECT * FROM taxi_service.role";
    public static final String GET_CATEGORIES = "SELECT * FROM taxi_service.category";
    public static final String GET_STATUSES = "SELECT * FROM taxi_service.status";


    //UPDATE
    public static final String UPDATE_USER_INFO = "UPDATE taxi_service.user SET " +
            "first_name=?, last_name=?, email=?" +
            "WHERE login=?";
    public static final String UPDATE_USER_AMOUNT_SPENT = "UPDATE taxi_service.user SET " +
            "amount_spent=? " +
            "WHERE login=?";
    public static final String UPDATE_CAB_STATUS = "UPDATE taxi_service.cab SET status_id=? WHERE id=?";
    //CHECK
    public static final String LOGIN_CHECK = "SELECT EXISTS(SELECT * FROM taxi_service.user WHERE login=?);";
    public static final String PASSWORD_CHECK = "SELECT STRCMP(password FROM taxi_service.user WHERE login=?, ?)";
    //SUM
    public static final String CALCULATE_SUM = "SELECT SUM(cost_of_order) FROM taxi_service.user WHERE login=?";
    public static final String CALCULATE_CABS_NUM = "SELECT COUNT(*) FROM taxi_service.cab";
    public static final String CALCULATE_ORDERS_NUM = "SELECT COUNT(*) FROM taxi_service.order";

}

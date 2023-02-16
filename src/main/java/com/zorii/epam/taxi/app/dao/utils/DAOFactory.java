package com.zorii.epam.taxi.app.dao.utils;

import com.zorii.epam.taxi.app.dao.CabDAO;
import com.zorii.epam.taxi.app.dao.OrderDAO;
import com.zorii.epam.taxi.app.dao.UserDAO;
import com.zorii.epam.taxi.app.dao.mysql.utils.MySQLDAOFactory;

import javax.sql.DataSource;

public abstract class DAOFactory {
    protected static CabDAO cabDAO;
    protected static OrderDAO orderDAO;
    protected static UserDAO userDAO;

    private static DAOFactory instance;
    protected DAOFactory() {
    }
    public static synchronized DAOFactory getInstance(DataSource dataSource) {
        if (instance == null) {
            instance = new MySQLDAOFactory(dataSource);
        }
        return instance;
    }

    public abstract CabDAO getCabDAO();
    public abstract OrderDAO getOrderDAO();
    public abstract UserDAO getUserDAO();


}

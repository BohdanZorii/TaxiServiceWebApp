package com.zorii.epam.taxi.app.dao.mysql.utils;

import com.zorii.epam.taxi.app.dao.CabDAO;
import com.zorii.epam.taxi.app.dao.OrderDAO;
import com.zorii.epam.taxi.app.dao.UserDAO;
import com.zorii.epam.taxi.app.dao.mysql.MySQLCabDAO;
import com.zorii.epam.taxi.app.dao.mysql.MySQLOrderDAO;
import com.zorii.epam.taxi.app.dao.mysql.MySQLUserDAO;
import com.zorii.epam.taxi.app.dao.utils.DAOFactory;
import com.zorii.epam.taxi.app.dao.utils.DataSourceManager;

import javax.sql.DataSource;

public class MySQLDAOFactory extends DAOFactory {

    private DataSource dataSource;
    public MySQLDAOFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public CabDAO getCabDAO() {
        if(cabDAO==null){
            cabDAO = new MySQLCabDAO(dataSource);
        }
        return cabDAO;
    }

    @Override
    public OrderDAO getOrderDAO() {
        if(orderDAO==null){
            orderDAO = new MySQLOrderDAO(dataSource);
        }
        return orderDAO;
    }

    @Override
    public UserDAO getUserDAO() {
        if(userDAO==null){
            userDAO = new MySQLUserDAO(dataSource);
        }
        return userDAO;
    }
}

package com.zorii.epam.taxi.app;

import com.zorii.epam.taxi.app.dao.mysql.utils.MySQLQueryBuilder;
import com.zorii.epam.taxi.app.dao.utils.DAOFactory;
import com.zorii.epam.taxi.app.dao.utils.DataSourceManager;
import com.zorii.epam.taxi.app.entity.order.Order;
import com.zorii.epam.taxi.app.entity.user.User;
import com.zorii.epam.taxi.app.service.CabService;
import com.zorii.epam.taxi.app.service.OrderService;
import com.zorii.epam.taxi.app.service.UserService;
import com.zorii.epam.taxi.app.utils.PasswordHasher;
import com.zorii.epam.taxi.app.web.dto.OrderDTO;

import java.util.ArrayList;
import java.util.List;

import static com.zorii.epam.taxi.app.utils.Convertor.convertOrderToDTO;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.EN;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.UA;

public class Demo {
    public static void main(String[] args) {
        try{
            MySQLQueryBuilder builder = MySQLQueryBuilder.getQueryBuilder();
            builder.getFullPostfix();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

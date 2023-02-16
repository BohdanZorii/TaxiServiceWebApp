package com.zorii.epam.taxi.app.dao;

import com.zorii.epam.taxi.app.entity.user.Role;
import com.zorii.epam.taxi.app.entity.user.User;
import com.zorii.epam.taxi.app.exception.DAOException;

import java.util.List;
import java.util.Map;


public interface UserDAO {
    void add(User user) throws DAOException;
    User get(String login) throws DAOException;
    void updateUserInfo(User user) throws DAOException;
    boolean isRegistered(String login) throws DAOException;
    boolean isPasswordCorrect(String password, String login) throws DAOException;
    int calculateAmountSpent(String login) throws DAOException;
    List<Role> getRoles() throws DAOException;
}

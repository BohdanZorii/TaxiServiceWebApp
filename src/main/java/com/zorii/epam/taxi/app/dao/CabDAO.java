package com.zorii.epam.taxi.app.dao;

import com.zorii.epam.taxi.app.entity.cab.Cab;
import com.zorii.epam.taxi.app.entity.cab.Category;
import com.zorii.epam.taxi.app.entity.cab.Status;
import com.zorii.epam.taxi.app.exception.DAOException;

import java.util.List;
import java.util.Map;

public interface CabDAO {
    Cab get(int id) throws DAOException;
    void updateStatus(int id, int statusId) throws DAOException;
    List<Cab> getSuitableCabs(int numOfPassengers, int categoryId) throws DAOException;
    int calculateTotalRecordsNum() throws DAOException;
    List<Status> getStatuses() throws DAOException;
    List<Category> getCategories() throws DAOException;
}

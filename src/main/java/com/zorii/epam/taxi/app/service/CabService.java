package com.zorii.epam.taxi.app.service;

import com.zorii.epam.taxi.app.dao.CabDAO;
import com.zorii.epam.taxi.app.dao.OrderDAO;
import com.zorii.epam.taxi.app.dao.utils.DAOFactory;
import com.zorii.epam.taxi.app.dao.utils.DataSourceManager;
import com.zorii.epam.taxi.app.entity.cab.Cab;
import com.zorii.epam.taxi.app.entity.cab.Category;
import com.zorii.epam.taxi.app.entity.cab.Status;
import com.zorii.epam.taxi.app.exception.DAOException;
import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.web.dto.CabDTO;
import com.zorii.epam.taxi.app.web.dto.OrderDTO;

import java.util.List;

public class CabService {
    private static final CabDAO cabDAO;

    static {
        cabDAO = DAOFactory.getInstance(DataSourceManager.getDataSource()).getCabDAO();
    }

    public static Cab getById(int id) throws ServiceException{
        try {
            return cabDAO.get(id);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
    public static void updateStatus(Cab cab) throws ServiceException{
        try {
            cabDAO.updateStatus(cab.getId(), cab.getStatus().getId());
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public static List<Cab> getSuitableCabs(OrderDTO orderDTO) throws ServiceException {
        int numOfPassengers = Integer.valueOf(orderDTO.getNumOfPassengers());
        int categoryId = getCategory(orderDTO.getCabCategory()).getId();
        try {
            return cabDAO.getSuitableCabs(numOfPassengers, categoryId);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public static Category getCategory(String name) throws ServiceException {
        try {
            List<Category> categories = cabDAO.getCategories();
            Category result = categories.get(0);
            for (Category category : categories) {
                if (category.getName().equals(name)) {
                    result = category;
                }
            }
            return result;

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public static Status getStatus(String name) throws ServiceException {
        try {
            List<Status> statuses = cabDAO.getStatuses();
            Status result = statuses.get(0);
            for (Status status : statuses) {
                if (status.getName().equals(name)) {
                    result = status;
                }
            }
            return result;

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public static List<Category> getCategories() throws ServiceException{
        try {
            List<Category> categories = cabDAO.getCategories();
            return categories;
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}

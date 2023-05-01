package com.zorii.epam.taxi.app.web.controller.action;

import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.service.UserService;
import com.zorii.epam.taxi.app.web.dto.OrderDTO;
import com.zorii.epam.taxi.app.web.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.zorii.epam.taxi.app.service.UserService.addAmountSpent;
import static com.zorii.epam.taxi.app.web.controller.action.utils.ActionHelper.selectMethod;
import static com.zorii.epam.taxi.app.web.controller.constant.Paths.*;
import static com.zorii.epam.taxi.app.service.OrderService.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.*;

public class MakeOrderAction implements Action{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        return selectMethod(req) ? usePost(req) : useGet(req);
    }

    private String usePost(HttpServletRequest req) throws ServiceException{
return null;

    }

    private String useGet(HttpServletRequest req){
        try {
            OrderDTO orderDTO = (OrderDTO) req.getSession().getAttribute(ORDER);
            addOrder(orderDTO);
            addAmountSpent(orderDTO.getClient().getLogin(), orderDTO.getCost());

            return SUCCESSFUL_ORDER_PAGE;
        }catch (ServiceException e){
            e.printStackTrace();
            //error message
            return null;
        }
    }

}

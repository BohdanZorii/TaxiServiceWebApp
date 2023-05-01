package com.zorii.epam.taxi.app.web.controller.action;

import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.service.CabService;
import com.zorii.epam.taxi.app.service.OrderService;
import com.zorii.epam.taxi.app.utils.Convertor;
import com.zorii.epam.taxi.app.web.dto.OrderDTO;
import com.zorii.epam.taxi.app.web.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.zorii.epam.taxi.app.utils.Randomizer.*;
import static com.zorii.epam.taxi.app.service.CabService.getCategory;
import static com.zorii.epam.taxi.app.utils.Convertor.convertCategoryToDTO;
import static com.zorii.epam.taxi.app.web.controller.action.utils.ActionHelper.getLocale;
import static com.zorii.epam.taxi.app.web.controller.action.utils.ActionHelper.selectMethod;
import static com.zorii.epam.taxi.app.service.OrderService.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Paths.*;

public class CalculatePriceAction implements Action{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        return selectMethod(req) ? usePost(req) : useGet(req);
    }

    private String usePost(HttpServletRequest req) throws ServiceException{
        OrderDTO orderDTO = buildOrder(req);

        int cost = calculateOrderCost(orderDTO);
        orderDTO.setCost(cost);

        req.getSession().setAttribute(ORDER, orderDTO);
        return SUBMIT_ORDER_PAGE;
    }

    private String useGet(HttpServletRequest req){
        return null;
    }

    OrderDTO buildOrder(HttpServletRequest req) throws ServiceException{
        return OrderDTO.builder()
                .departureAddress(req.getParameter(DEPARTURE_ADDR))
                .destinationAddress(req.getParameter(DESTINATION_ADDR))
                .numOfPassengers(req.getParameter(NUM_OF_PASSENGERS))
                .cabCategory(convertCategoryToDTO(getCategory(req.getParameter(CATEGORY)), getLocale(req)))
                .distance(String.valueOf(generateDistance()))
                .client((UserDTO) req.getSession().getAttribute(CURRENT_USER))
                .build();
    }
}

package com.zorii.epam.taxi.app.web.controller.action;

import com.zorii.epam.taxi.app.dao.mysql.utils.MySQLQueryBuilder;
import com.zorii.epam.taxi.app.entity.order.Order;
import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.service.OrderService;
import com.zorii.epam.taxi.app.utils.Convertor;
import com.zorii.epam.taxi.app.utils.Paginator;
import com.zorii.epam.taxi.app.utils.QueryBuilder;
import com.zorii.epam.taxi.app.web.dto.OrderDTO;

import static com.zorii.epam.taxi.app.utils.Convertor.convertOrderToDTO;
import static com.zorii.epam.taxi.app.web.controller.action.utils.ActionHelper.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Paths.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class DisplayOrdersAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return selectMethod(request) ? usePost(request, response) : useGet(request, response);
    }

    public String useGet(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        int numOfOrders = OrderService.getTotalRecordsNum();

        if (numOfOrders == 0) {
            return OVERVIEW_ORDERS_PAGE;
        }

        int numOfPages = Paginator.calculatePagesNum(numOfOrders);
        int currentPage = transferPaginationInfoToRequest(request, numOfPages);
        System.out.println(currentPage);

        QueryBuilder queryBuilder = MySQLQueryBuilder.getQueryBuilder();
        transferAttributesToQueryBuilder(request, queryBuilder);
        String postfixQuery = queryBuilder.getFullPostfix();

        List<Order> ordersList = OrderService.getOrdersByConditions(postfixQuery);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for(Order order: ordersList){
            orderDTOList.add(convertOrderToDTO(order));
        }

        request.setAttribute(ORDERS_LIST, orderDTOList);
        request.getSession().setAttribute(SORT_BY_OPTIONS, DEFAULT_SORTING_OPTIONS);
        request.setAttribute(PAGINATION_CURRENT_PAGE, currentPage);

        return OVERVIEW_ORDERS_PAGE;
    }

    public String usePost(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return null;
    }
}

package com.zorii.epam.taxi.app.web.controller.action;

import com.zorii.epam.taxi.app.dao.mysql.utils.MySQLQueryBuilder;
import com.zorii.epam.taxi.app.entity.order.Order;
import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.service.OrderService;
import com.zorii.epam.taxi.app.utils.Paginator;
import com.zorii.epam.taxi.app.utils.QueryBuilder;
import com.zorii.epam.taxi.app.web.dto.OrderDTO;

import static com.zorii.epam.taxi.app.service.OrderService.getTotalRecordsNum;
import static com.zorii.epam.taxi.app.utils.Convertor.convertOrderToDTO;
import static com.zorii.epam.taxi.app.web.controller.action.utils.ActionHelper.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Paths.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

public class DisplayOrdersAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return selectMethod(request) ? usePost(request, response) : useGet(request, response);
    }

    public String useGet(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String locale = getLocale(request);
        int numOfOrders = getTotalRecordsNum();

        if (numOfOrders == 0) {
            return OVERVIEW_ORDERS_PAGE;
        }

        int numOfPages = Paginator.calculatePagesNum(numOfOrders);
        int currentPage = transferPaginationInfoToRequest(request, numOfPages);

        QueryBuilder queryBuilder = MySQLQueryBuilder.getQueryBuilder();
        transferAttributesToQueryBuilder(request, queryBuilder);
        String postfixQuery = queryBuilder.getFullPostfix();

        List<Order> ordersList = OrderService.getOrdersByConditions(postfixQuery);

        List<OrderDTO> orderDTOList = new ArrayList<>();
        for(Order order: ordersList){
            orderDTOList.add(convertOrderToDTO(order, locale));
        }
        request.setAttribute(ORDERS_LIST, orderDTOList);

        request.setAttribute(SORT_BY_OPTIONS, DEFAULT_SORTING_OPTIONS);
        System.out.println(orderDTOList);
        System.out.println(getUniqueClientsNames());
        request.setAttribute(CLIENT_OPTIONS, getUniqueClientsNames());
        request.setAttribute(DATE_OPTIONS, getUniqueDates());

        request.setAttribute(PAGINATION_CURRENT_PAGE, currentPage);
        transferAttributes(request);
        return OVERVIEW_ORDERS_PAGE;
    }

    public String usePost(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return null;
    }

    private void transferAttributes(HttpServletRequest request){
        request.setAttribute(SORT_BY_FIELD, request.getParameter(SORT_BY_FIELD));
        request.setAttribute(CLIENT_FILTER, request.getParameter(CLIENT_FILTER));
        request.setAttribute(DATE_FILTER, request.getParameter(DATE_FILTER));
    }

    private List<String> getUniqueClientsNames() throws ServiceException{
        List<Order> ordersList = OrderService.getOrdersByConditions("") ;
        Set<String> set = ordersList.stream().map(order -> order.getClientLogin()).collect(Collectors.toSet());
        return set.stream().toList();
    }

    private List<Date> getUniqueDates() throws ServiceException{
        List<Order> ordersList = OrderService.getOrdersByConditions("") ;
        Set<Date> set = ordersList.stream().map(order -> order.getDateOfOrder()).collect(Collectors.toSet());
        return set.stream().toList();
    }
}

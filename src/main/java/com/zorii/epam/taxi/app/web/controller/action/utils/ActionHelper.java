package com.zorii.epam.taxi.app.web.controller.action.utils;

import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.utils.QueryBuilder;

import javax.servlet.http.HttpServletRequest;

import static com.zorii.epam.taxi.app.utils.Paginator.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.PAGINATION_END_PAGE;

public class ActionHelper {
    public static boolean selectMethod(HttpServletRequest request) {
        return request.getMethod().equals("POST");
    }

    public static String getLocale(HttpServletRequest request){
        return (String) request.getSession().getAttribute(LOCALE);
    }
    public static QueryBuilder transferAttributesToQueryBuilder(HttpServletRequest request, QueryBuilder builder) throws ServiceException {
        String currentPageString = String.valueOf(request.getAttribute(PAGINATION_CURRENT_PAGE));
        int currentPage = parseCurrentPageString(currentPageString);
        builder.setSortByField(request.getParameter(SORT_BY_FIELD))
                .setClientFilter(request.getParameter(CLIENT_FILTER))
                .setDateFilter(request.getParameter(DATE_FILTER))
                .setOffset(calculateOffset(currentPage));

        return builder;
    }

    public static int transferPaginationInfoToRequest(HttpServletRequest request, int numOfPages) throws ServiceException {
        int currentPage;
        String currentPageString = request.getParameter(PAGINATION_CURRENT_PAGE);
        currentPage = parseCurrentPageString(currentPageString);
        request.setAttribute(PAGINATION_CURRENT_PAGE, currentPage);
        request.setAttribute(PAGINATION_START_PAGE, calculateStartPage(currentPage, numOfPages));
        request.setAttribute(PAGINATION_END_PAGE, calculateEndPage(currentPage, numOfPages));

        return currentPage;
    }

    private static int parseCurrentPageString(String currentPageString) throws ServiceException {

        if (currentPageString == null) {
            return 1;

        } else {
            try {
                return Integer.parseInt(currentPageString);
            } catch (NumberFormatException e) {
                throw new ServiceException(e);
            }
        }
    }

    private ActionHelper() {
    }
}

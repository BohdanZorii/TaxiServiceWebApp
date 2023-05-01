package com.zorii.epam.taxi.app.web.controller.constant;

import java.util.ArrayList;
import java.util.List;

public class Params {
    public static final String LOCALE = "locale";
    public static final String EN="en";
    public static final String UA="uk_UA";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String PASSWORD_REPEATED = "repeatedPassword";
    public static final String ROLE = "role";
    public static final String ERROR = "error";
    public static final String ACTION_NAME = "action";
    public static final String CURRENT_USER = "currentUser";
    public static final String USER = "user";
    public static final String ORIGINAL_LOGIN = "originalLogin";
    public static final String CATEGORIES = "categories";
    public static final String CATEGORY = "category";
    public static final String DEPARTURE_ADDR = "departureAddr";
    public static final String DESTINATION_ADDR = "destinationAddr";
    public static final String NUM_OF_PASSENGERS = "numOfPassengers";
    public static final String ORDER = "order";
    public static final String PAGINATION_START_PAGE = "startPage";
    public static final String PAGINATION_END_PAGE = "endPage";
    public static final String PAGINATION_CURRENT_PAGE = "currentPage";
    public static final String SORT_BY_FIELD = "sortByField";
    public static final String SORT_BY_OPTIONS = "sortByOptions";
    public static final String CLIENT_OPTIONS = "clientOptions";
    public static final String DATE_OPTIONS = "dateOptions";
    public static final List<String> DEFAULT_SORTING_OPTIONS= new ArrayList<>(List.of("date_of_order", "cost_of_order"));
    public static final String SORT_ORDER = "sortOrder";
    public static final String CLIENT_FILTER = "clientFilter";
    public static final String DATE_FILTER = "dateFilter";
    public static final String ORDERS_LIST = "orders";


}

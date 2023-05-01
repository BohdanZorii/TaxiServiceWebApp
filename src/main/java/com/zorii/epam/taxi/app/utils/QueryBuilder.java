package com.zorii.epam.taxi.app.utils;

import java.util.ArrayList;
import java.util.List;

import static com.zorii.epam.taxi.app.dao.constant.QueryBuilderConstants.*;

public abstract class QueryBuilder {
    protected List<String> filters;
    protected String sortByField;
    protected String sortingOrder = ASCENDING_ORDER;
    protected int offset;

    {
        filters = new ArrayList<>();
    }

    public abstract String getOrderPostfix();

    public abstract String getFilterPostfix();

    public abstract String getLimitPostfix();

    public abstract String getFullPostfix();

    protected QueryBuilder() {
    }

    public QueryBuilder setDateFilter(String date) {
        if (date != null) {
            filters.add("date_of_order='" + date+"'");
        }
        return this;
    }

    public QueryBuilder setClientFilter(String clientLogin) {
        if (clientLogin != null) {
            filters.add("client_login='" + clientLogin+"'");
        }
        return this;
    }

    public QueryBuilder setSortByField(String sortByField) {
        this.sortByField = sortByField;
        return this;
    }

    public QueryBuilder setSortingOrder(String sortingOrder) {
        this.sortingOrder = sortingOrder;
        return this;
    }

    public QueryBuilder setOffset(int offset) {
        this.offset = offset;
        return this;
    }
}

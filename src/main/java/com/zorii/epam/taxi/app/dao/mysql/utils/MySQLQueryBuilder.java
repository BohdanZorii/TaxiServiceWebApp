package com.zorii.epam.taxi.app.dao.mysql.utils;

import com.zorii.epam.taxi.app.utils.QueryBuilder;

import java.util.StringJoiner;

import static com.zorii.epam.taxi.app.utils.Paginator.DEFAULT_PAGE_CAPACITY;

public class MySQLQueryBuilder extends QueryBuilder {

    @Override
    public String getOrderPostfix() {
        if (sortByField == null) {
            return "";
        }
        return " ORDER BY " + sortByField + " " + sortingOrder;
    }

    @Override
    public String getFilterPostfix() {
        if(filters.isEmpty()){
            return "";
        }
        StringJoiner stringJoiner = new StringJoiner(" AND ", " WHERE ", " ").setEmptyValue("");
        filters.forEach(stringJoiner::add);
        return stringJoiner.toString();
    }

    @Override
    public String getLimitPostfix() {
        return " LIMIT " + offset + ", " + DEFAULT_PAGE_CAPACITY;
    }

    @Override
    public String getFullPostfix() {
        return getFilterPostfix() + getOrderPostfix() + getLimitPostfix();
    }

    private MySQLQueryBuilder() {
    }
    public static MySQLQueryBuilder getQueryBuilder(){
        return new MySQLQueryBuilder();
    }
}

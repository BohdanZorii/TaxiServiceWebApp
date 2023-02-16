package com.zorii.epam.taxi.app.web.controller.action;

import com.zorii.epam.taxi.app.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException;
}

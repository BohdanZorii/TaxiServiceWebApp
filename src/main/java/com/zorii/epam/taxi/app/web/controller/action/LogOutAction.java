package com.zorii.epam.taxi.app.web.controller.action;

import com.zorii.epam.taxi.app.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.zorii.epam.taxi.app.web.controller.action.utils.ActionHelper.selectMethod;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Paths.MAIN_PAGE;

public class LogOutAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return selectMethod(request) ? usePost(request) : useGet(request);
    }

    private String usePost(HttpServletRequest request) throws ServiceException {
      return null;
    }


    private String useGet(HttpServletRequest request) throws ServiceException {
        HttpSession session = request.getSession();
        String locale = (String) session.getAttribute(LOCALE);
        session.invalidate();
        request.getSession(true).setAttribute(LOCALE, locale);

        return MAIN_PAGE;
    }
}

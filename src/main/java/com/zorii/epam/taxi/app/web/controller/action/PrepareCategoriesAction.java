package com.zorii.epam.taxi.app.web.controller.action;

import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.service.CabService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.zorii.epam.taxi.app.web.controller.action.utils.ActionHelper.selectMethod;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.CATEGORIES;
import static com.zorii.epam.taxi.app.web.controller.constant.Paths.MAKE_ORDER_PAGE;

public class PrepareCategoriesAction implements Action{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        return selectMethod(req) ? usePost(req) : useGet(req);
    }

    private String usePost(HttpServletRequest req) throws ServiceException{
        req.getSession().setAttribute(CATEGORIES, CabService.getCategories());
        return MAKE_ORDER_PAGE;
    }

    private String useGet(HttpServletRequest req){
        return null;
    }
}

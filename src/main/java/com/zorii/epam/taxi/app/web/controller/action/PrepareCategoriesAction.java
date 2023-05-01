package com.zorii.epam.taxi.app.web.controller.action;

import com.zorii.epam.taxi.app.entity.cab.Category;
import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.service.CabService;
import com.zorii.epam.taxi.app.utils.Convertor;
import com.zorii.epam.taxi.app.web.dto.CategoryDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import static com.zorii.epam.taxi.app.web.controller.action.utils.ActionHelper.getLocale;
import static com.zorii.epam.taxi.app.web.controller.action.utils.ActionHelper.selectMethod;
import static com.zorii.epam.taxi.app.utils.Convertor.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.CATEGORIES;
import static com.zorii.epam.taxi.app.web.controller.constant.Paths.MAKE_ORDER_PAGE;

public class PrepareCategoriesAction implements Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        return selectMethod(req) ? usePost(req) : useGet(req);
    }

    private String usePost(HttpServletRequest req) throws ServiceException {
        return null;
    }

    private String useGet(HttpServletRequest req) throws ServiceException {
        String locale = getLocale(req);
        List<Category> categories = CabService.getCategories();
        List<CategoryDTO> DTOs = new ArrayList<>();
        for (Category category: categories){
            DTOs.add(convertCategoryToDTO(category, locale));
        }
        req.getSession().setAttribute(CATEGORIES, DTOs);
        return MAKE_ORDER_PAGE;
    }
}

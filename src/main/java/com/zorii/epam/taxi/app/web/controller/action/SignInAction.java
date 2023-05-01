package com.zorii.epam.taxi.app.web.controller.action;

import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.exception.UserSigningInException;
import com.zorii.epam.taxi.app.web.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;

import static com.zorii.epam.taxi.app.web.controller.action.utils.ActionHelper.selectMethod;
import static com.zorii.epam.taxi.app.service.UserService.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Paths.*;

public class SignInAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return selectMethod(request) ? usePost(request) : useGet(request);
    }

    private String usePost(HttpServletRequest request) throws ServiceException {
        UserDTO userDTO = null;

        try {
            request.setCharacterEncoding("UTF-8");
        }catch (UnsupportedEncodingException e){}
        try {

            userDTO = signUserIn(request.getParameter(LOGIN), request.getParameter(PASSWORD));

            request.getSession().setAttribute(CURRENT_USER, userDTO);
            return MAIN_PAGE;
        } catch (UserSigningInException e) {
//            request.getSession().setAttribute(LOGIN, userDTO.getLogin());
//            request.getSession().setAttribute(ERROR_PAGE, e.getMessage());
            e.printStackTrace();
            return SIGN_IN_PAGE;
        }
    }

    private String useGet(HttpServletRequest request) throws ServiceException {
        return null;
    }

}

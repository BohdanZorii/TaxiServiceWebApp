package com.zorii.epam.taxi.app.web.controller.action;

import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.web.dto.UserDTO;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.zorii.epam.taxi.app.service.UserService.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Paths.*;
import static com.zorii.epam.taxi.app.web.controller.action.utils.ActionHelper.*;

public class SignUpAction implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return selectMethod(request) ? usePost(request, response) : useGet(request);
    }

    private String usePost(HttpServletRequest request, HttpServletResponse response) throws ServiceException{
        UserDTO userDTO = null;
        try {
            userDTO = buildUserDTO(request);
            addUser(userDTO, request.getParameter(PASSWORD).toString(),
                    request.getParameter(PASSWORD_REPEATED).toString());

            return new SignInAction().execute(request, response);

        }catch (ServiceException e){
//            request.getSession().setAttribute(USER, userDTO);
//            request.getSession().setAttribute(ERROR, e.getMessage());
            e.printStackTrace();
            return SIGN_UP_PAGE;
        }
    }

    private String useGet(HttpServletRequest request) throws ServiceException{return null;}

    private UserDTO buildUserDTO(HttpServletRequest request){
        return UserDTO.builder()
                .firstName(request.getParameter(FIRST_NAME))
                .lastName(request.getParameter(LAST_NAME))
                .login(request.getParameter(LOGIN))
                .email(request.getParameter(EMAIL))
                .build();
    }
}

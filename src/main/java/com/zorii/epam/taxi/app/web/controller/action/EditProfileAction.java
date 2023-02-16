package com.zorii.epam.taxi.app.web.controller.action;

import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.web.dto.UserDTO;
import com.zorii.epam.taxi.app.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.zorii.epam.taxi.app.web.controller.action.utils.ActionHelper.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Paths.*;

public class EditProfileAction implements Action{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        return selectMethod(req) ? usePost(req) : useGet(req);
    }

    private String usePost(HttpServletRequest req) throws ServiceException{
        UserDTO currentUser = (UserDTO) req.getSession().getAttribute(CURRENT_USER);
        UserDTO updatedUser = buildUserDTO(req, currentUser);
        UserService.updateInfo(updatedUser);

        req.getSession().removeAttribute(CURRENT_USER);
        req.getSession().setAttribute(CURRENT_USER, updatedUser);
        return PROFILE_PAGE;
    }

    private String useGet(HttpServletRequest req){
        return null;
    }

    private UserDTO buildUserDTO(HttpServletRequest request, UserDTO currentUser){
        return UserDTO.builder()
                .firstName(request.getParameter(FIRST_NAME))
                .lastName(request.getParameter(LAST_NAME))
                .email(request.getParameter(EMAIL))
                .login(currentUser.getLogin())
                .role(currentUser.getRole()).build();
    }
}

package com.zorii.epam.taxi.app.web.controller;

import com.zorii.epam.taxi.app.web.controller.action.Action;
import com.zorii.epam.taxi.app.web.controller.action.utils.ActionFactory;
import com.zorii.epam.taxi.app.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.zorii.epam.taxi.app.web.controller.constant.Paths.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.*;

public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(doStuff(req, resp)).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(doStuff(req, resp));
    }

    private String doStuff(HttpServletRequest req, HttpServletResponse resp) {
        String path = ERROR_PAGE;
        Action action = ActionFactory.getInstance().getAction(req.getParameter(ACTION_NAME));

        try {
            path = action.execute(req, resp);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return path;
    }
}

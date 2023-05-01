package com.zorii.epam.taxi.app.web.filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EncodingFilter extends HttpFilter {
    private String encoding;


    @Override
    public void init(FilterConfig config) {
        encoding = config.getInitParameter("encoding");
    }



    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }
}

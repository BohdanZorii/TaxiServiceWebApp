package com.zorii.epam.taxi.app.web.filter;


import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import static com.zorii.epam.taxi.app.web.controller.constant.Params.LOCALE;


public class LocaleFilter extends HttpFilter {
    private static final String REFERER = "referer";
    private String defaultLocale;

    @Override
    public void init(FilterConfig config) {
        defaultLocale = config.getInitParameter("defaultLocale");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String locale = request.getParameter(LOCALE);
        if (isNotBlank(locale)) {
            request.getSession().setAttribute(LOCALE, locale);
            response.addCookie(new Cookie(LOCALE, locale));
            response.sendRedirect(request.getHeader(REFERER));
        } else {
            String sessionLocale = (String) request.getSession().getAttribute(LOCALE);
            if (isBlank(sessionLocale)) {
                request.getSession().setAttribute(LOCALE, getCookiesLocale(request));
            }
            chain.doFilter(request, response);
        }
    }
    private String getCookiesLocale(HttpServletRequest request) {
        return Stream.ofNullable(request.getCookies())
                .flatMap(Arrays::stream)
                .filter(cookie -> cookie.getName().equals(LOCALE))
                .map(Cookie::getValue)
                .findAny().orElse(defaultLocale);
    }

    private boolean isBlank(String locale) {
        return locale == null || locale.isEmpty();
    }

    private boolean isNotBlank(String locale) {
        return !isBlank(locale);
    }
}



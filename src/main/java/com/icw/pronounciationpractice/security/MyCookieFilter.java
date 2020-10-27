package com.icw.pronounciationpractice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Configuration
public class MyCookieFilter extends GenericFilterBean {

    public static final String MY_COOKIE_NAME = "your-cookie-name";


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        checkCookie(httpServletRequest, httpServletResponse);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void checkCookie(HttpServletRequest request, HttpServletResponse servletResponse) {
       // boolean cookieExists = Arrays.stream(request.getCookies()).anyMatch(cookie -> cookie.getName().equalsIgnoreCase(MY_COOKIE_NAME));
       // if (!cookieExists) {
            String cookieValue = "your-cookie-value";
            Cookie newCookie = new Cookie(MY_COOKIE_NAME, cookieValue);
            servletResponse.addCookie(newCookie);
        //}
    }
}
package com.naukma.soccer.spring_security;

import com.naukma.soccer.facades.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class RefererAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.addCookie(new Cookie("user", authentication.getName()));
        httpServletResponse.sendRedirect("http://localhost:63342/soccer/frontend/index.html?_ijt=cacjv983ukbm910lbahvbefl78");
    }
}


package com.naukma.soccer.controllers;

import com.naukma.soccer.dto.CreateUserDto;
import com.naukma.soccer.facades.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping
    public void test() {
        System.out.println("work");
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void processRegistration(HttpServletRequest request, HttpServletResponse response, CreateUserDto createUserDto) {
        userFacade.registerUser(createUserDto);
        try {
            request.login(createUserDto.getUsername(), createUserDto.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        try {
            response.addCookie(new Cookie("user", userFacade.getSessionUser().getEmail()));
            response.sendRedirect("http://localhost:63342/soccer/frontend/index.html?_ijt=cacjv983ukbm910lbahvbefl78");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

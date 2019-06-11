package com.naukma.soccer.controllers;

import com.naukma.soccer.dto.UserDto;
import com.naukma.soccer.facades.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("/all")
    public List<UserDto> findAllUsers() {
        return userFacade.findAll();
    }

}

package com.naukma.soccer.controllers;

import com.naukma.soccer.converters.UserToUserDtoConverter;
import com.naukma.soccer.dto.UserDto;
import com.naukma.soccer.facades.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private UserToUserDtoConverter converter;

    @GetMapping("/all")
    public List<UserDto> findAllUsers() {
        return userFacade.findAll();
    }

    @GetMapping("/current")
    public UserDto getCurrentUser() {
        return converter.convert(userFacade.getSessionUser());
    }

}

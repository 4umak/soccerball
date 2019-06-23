package com.naukma.soccer.facades;

import com.naukma.soccer.dto.CreateUserDto;
import com.naukma.soccer.dto.UserDto;
import com.naukma.soccer.entities.Client;

import java.util.List;

public interface UserFacade {

    List<UserDto> findAll();
    UserDto findByEmail(String email);
    void registerUser(CreateUserDto userDto);
    Client getSessionUser();
}

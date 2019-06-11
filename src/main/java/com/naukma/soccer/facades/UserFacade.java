package com.naukma.soccer.facades;

import com.naukma.soccer.dto.UserDto;

import java.util.List;

public interface UserFacade {

    List<UserDto> findAll();
    UserDto findByEmail(String email);
}
package com.naukma.soccer.facades;

import com.naukma.soccer.converters.CreateUserDtoToClientConverter;
import com.naukma.soccer.converters.UserToUserDtoConverter;
import com.naukma.soccer.dto.CreateUserDto;
import com.naukma.soccer.dto.UserDto;
import com.naukma.soccer.entities.Client;
import com.naukma.soccer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultUserFacade implements UserFacade {

    @Autowired
    private UserToUserDtoConverter converter;

    @Autowired
    private CreateUserDtoToClientConverter toClientConverter;

    @Autowired
    private UserService userService;

    @Override
    public List<UserDto> findAll() {
        List<UserDto> list = new ArrayList<>();
        for (Client client : userService.findAll()) {
            list.add(converter.convert(client));
        }
        return list;
    }

    @Override
    public UserDto findByEmail(String email) {
        return converter.convert(userService.findByEmail(email));
    }

    @Override
    public void registerUser(CreateUserDto userDto) {
        userService.saveUser(toClientConverter.convert(userDto));
    }
}

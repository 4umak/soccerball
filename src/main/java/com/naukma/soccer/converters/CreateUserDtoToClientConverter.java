package com.naukma.soccer.converters;

import com.naukma.soccer.dto.CreateUserDto;
import com.naukma.soccer.entities.Client;
import com.naukma.soccer.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDtoToClientConverter implements Converter<CreateUserDto, Client> {

    @Autowired
    private RoleService roleService;

    @Override
    public Client convert(CreateUserDto userDto) {
        return Client.builder().id(12).first_name(userDto.getFirstName())
                .last_name(userDto.getLastName())
                .email(userDto.getUsername())
                .password(userDto.getPassword())
                .roleList(roleService.findAllByName("USER")).build();
    }
}

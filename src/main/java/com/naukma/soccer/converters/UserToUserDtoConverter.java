package com.naukma.soccer.converters;

import com.naukma.soccer.dto.RoleDto;
import com.naukma.soccer.dto.UserDto;
import com.naukma.soccer.enteties.Client;
import com.naukma.soccer.enteties.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToUserDtoConverter implements Converter<Client, UserDto> {

    @Autowired
    private RoleToRoleDtoConverter toRoleDtoConverter;

    @Override
    public UserDto convert(Client client) {
        List<RoleDto> roleDtoList = new ArrayList<>();
        for(Role role : client.getRoleList()) {
            roleDtoList.add(toRoleDtoConverter.convert(role));
        }
        return UserDto.builder().email(client.getEmail())
                .first_name(client.getFirst_name())
                .last_name(client.getLast_name())
                .roleDtoList(roleDtoList)
                .build();
    }
}

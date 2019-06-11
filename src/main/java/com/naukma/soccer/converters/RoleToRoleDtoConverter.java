package com.naukma.soccer.converters;

import com.naukma.soccer.dto.RoleDto;
import com.naukma.soccer.enteties.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleToRoleDtoConverter implements Converter<Role, RoleDto> {

    @Override
    public RoleDto convert(Role role) {
        return RoleDto.builder().roleName(role.getName()).build();
    }
}

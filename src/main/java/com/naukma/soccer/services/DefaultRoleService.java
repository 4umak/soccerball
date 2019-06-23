package com.naukma.soccer.services;

import com.naukma.soccer.entities.Role;
import com.naukma.soccer.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultRoleService implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAllByName(String name) {
        return roleRepository.findAllByName(name);
    }
}

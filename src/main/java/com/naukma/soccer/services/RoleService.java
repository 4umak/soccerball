package com.naukma.soccer.services;

import com.naukma.soccer.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllByName(String name);
}

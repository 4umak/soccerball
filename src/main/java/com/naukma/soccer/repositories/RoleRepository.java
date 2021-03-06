package com.naukma.soccer.repositories;

import com.naukma.soccer.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findAllByName(String name);
}

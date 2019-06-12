package com.naukma.soccer.repositories;

import com.naukma.soccer.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);
    List<Client> findAll();
}

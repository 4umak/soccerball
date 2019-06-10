package com.naukma.soccer.repositories;

import com.naukma.soccer.enteties.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);
}

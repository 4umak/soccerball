package com.naukma.soccer.services;

import com.naukma.soccer.enteties.Client;

import java.util.List;

public interface UserService {

    Client findByEmail(String email);
    List<Client> findAll();
}

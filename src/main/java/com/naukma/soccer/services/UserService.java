package com.naukma.soccer.services;

import com.naukma.soccer.entities.Client;

import java.util.List;

public interface UserService {

    Client findByEmail(String email);
    Client findById(int id);
    List<Client> findAll();
    Client getSessionUser();
    void saveUser(Client client);
}

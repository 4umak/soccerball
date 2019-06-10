package com.naukma.soccer.services;

import com.naukma.soccer.enteties.Client;
import com.naukma.soccer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void saveUser(Client client) {
        userRepository.save(client);
    }

    public Client findByEmail(String s) {
        return userRepository.findByEmail(s);
    }
}

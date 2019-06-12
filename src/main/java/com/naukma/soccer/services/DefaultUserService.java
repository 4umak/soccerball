package com.naukma.soccer.services;

import com.naukma.soccer.entities.Client;
import com.naukma.soccer.repositories.UserRepository;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void saveUser(Client client) {
        String password = client.getPassword();
        client.setPassword(passwordEncoder.encode(password));
        userRepository.save(client);
    }

    public Client findByEmail(String s) {
        return userRepository.findByEmail(s);
    }

    @Override
    public List<Client> findAll() {
        getSessionUser();
        return userRepository.findAll();
    }

    @Override
    public Client getSessionUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return findByEmail(authentication.getName());
    }

}

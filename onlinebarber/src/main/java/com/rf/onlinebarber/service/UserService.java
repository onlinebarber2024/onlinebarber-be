package com.rf.onlinebarber.service;

import com.rf.onlinebarber.exception.UserNotFoundException;
import com.rf.onlinebarber.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


public class UserService implements UserDetailsService {
private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        return repository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }
}

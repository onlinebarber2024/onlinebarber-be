package com.rf.onlinebarber.service;

import com.rf.onlinebarber.exception.UserNotFoundException;
import com.rf.onlinebarber.model.BaseUser;
import com.rf.onlinebarber.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseUserService {
    private final UserRepository repository;
    public BaseUser findById(Long id){
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }
    protected BaseUser findByEmail(String email){return repository.findByEmail(email).orElseThrow(UserNotFoundException::new);}
}

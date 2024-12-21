package com.rf.onlinebarber.service.token.impl;

import com.rf.onlinebarber.exception.TokenException;
import com.rf.onlinebarber.model.BaseUser;
import com.rf.onlinebarber.model.Token;
import com.rf.onlinebarber.repository.TokenRepository;
import com.rf.onlinebarber.service.token.TokenService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Primary
public class MyTokenService implements TokenService {
    private final TokenRepository repository;

    public MyTokenService(TokenRepository repository) {
        this.repository = repository;
    }

    @Override
    public Token createToken(BaseUser user) {
        String tok= UUID.randomUUID().toString();
        Token db= new Token.TokenBuilder().Token(tok).User(user).build();
        repository.save(db);
        return db;
    }

    @Override
    public BaseUser verifyToken(String token) {
        return getToken(token).getUser();
    }

    @Override
    public void logout(String token) {
        repository.delete(getToken(token));
    }
    public Token getToken(String token){
        return repository.findById(token).orElseThrow(TokenException::new);
    }
}

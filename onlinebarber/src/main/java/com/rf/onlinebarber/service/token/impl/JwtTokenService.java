package com.rf.onlinebarber.service.token.impl;

import com.rf.onlinebarber.model.BaseUser;
import com.rf.onlinebarber.model.Token;
import com.rf.onlinebarber.service.BaseUserService;
import com.rf.onlinebarber.service.UserService;
import com.rf.onlinebarber.service.token.TokenService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
@RequiredArgsConstructor
public class JwtTokenService implements TokenService {
    SecretKey key= Keys.hmacShaKeyFor("secret-must-be-at-least-32-chars".getBytes());
    private final BaseUserService service;
    @Override
    public Token createToken(BaseUser user) {
        String token= Jwts.builder().setSubject(Long.toString(user.getId())).signWith(key).compact();
        return new Token.TokenBuilder().Token(token).User(user).build();
    }

    @Override
    public BaseUser verifyToken(String authorizationHeader) {
        if (authorizationHeader==null) return  null;
        String token=authorizationHeader.split(" ")[1];
        JwtParser parser= Jwts.parser().setSigningKey(key).build();
        try {
            Jws<Claims> claims= parser.parseClaimsJws(token);
            long userId=Long.valueOf(claims.getBody().getSubject());
            System.out.println(userId);
            BaseUser user=service.findById(userId);
            return user;
        }catch (JwtException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void logout(String token) {

    }
}

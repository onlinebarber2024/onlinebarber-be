package com.rf.onlinebarber.service;

import com.rf.onlinebarber.dto.AuthDto;
import com.rf.onlinebarber.dto.LoginRequest;
import com.rf.onlinebarber.dto.converter.DtoConverter;
import com.rf.onlinebarber.exception.AuthException;
import com.rf.onlinebarber.model.BaseUser;
import com.rf.onlinebarber.model.Token;
import com.rf.onlinebarber.service.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final BaseUserService userService;
    private final PasswordEncoder encoder;
    private final TokenService tokenService;
    private final DtoConverter converter;
    public AuthDto login(LoginRequest request) {
        BaseUser user=userService.findByEmail(request.getEmail());
        if(!encoder.matches(request.getPassword(),user.getPassword())) throw new AuthException();
        Token token=tokenService.createToken(user);
        AuthDto dto=AuthDto.builder().token(token.getToken()).user(converter.convertUser(user)).build();
        return dto;
    }

    public void logout(String token) {
        tokenService.logout(token);
    }

}

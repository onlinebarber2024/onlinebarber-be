package com.rf.onlinebarber.security;

import com.rf.onlinebarber.model.BaseUser;
import com.rf.onlinebarber.service.token.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class Filter extends OncePerRequestFilter {
    private final TokenService tokenService;

    public Filter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token=getToken(request);
        if(token!=null){
            BaseUser user=tokenService.verifyToken(token);
            if(user!=null){
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
    public String getToken(HttpServletRequest request){
        var cookies=request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("login-token") && cookie.getValue()!=null && !cookie.getValue().isEmpty()){
                    return cookie.getValue();
                }

            }
        }
        return null;
    }
}

package com.rf.onlinebarber.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final Filter filter;

    public WebSecurityConfig(Filter filter) {
        this.filter = filter;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests((x)->
                x.requestMatchers("/api/v1/model/add/*","/api/v1/model/delete/*","/api/v1/barber/delete/*","/api/v1/appointment/list/barber/*").hasRole("BARBER")
                        .requestMatchers("/api/v1/appointment/{id}","/api/v1/appointment/delete/*").hasAnyRole("BARBER","CUSTOMER")
                        .requestMatchers("/api/v1/customer/delete/*","/api/v1/appointment/list/customer/*").hasRole("CUSTOMER").anyRequest().permitAll());
                ;
        http.csrf(AbstractHttpConfigurer::disable);
        http.headers(AbstractHttpConfigurer::disable);
        http.sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}

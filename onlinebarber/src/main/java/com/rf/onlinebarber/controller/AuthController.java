package com.rf.onlinebarber.controller;

import com.rf.onlinebarber.config.ApiPaths;
import com.rf.onlinebarber.dto.ApiResponse;
import com.rf.onlinebarber.dto.AuthDto;
import com.rf.onlinebarber.dto.LoginRequest;
import com.rf.onlinebarber.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(ApiPaths.AUTH)

public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    // giriş
    @PostMapping(ApiPaths.LOGIN)
    public ResponseEntity<ApiResponse<AuthDto>> login(@Valid @RequestBody LoginRequest request){
        int oneMonth = 30 * 24 * 60 * 60;
        AuthDto dto=service.login(request);
        ResponseCookie cookie=ResponseCookie.from("login-token",dto.getToken()).path("/").maxAge(oneMonth).httpOnly(true).build();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,cookie.toString()).body(ApiResponse.ok("Giriş Başarili",dto));
    }
    // çıkış
    @DeleteMapping(ApiPaths.LOGOUT)
    public ResponseEntity<?> logout(@CookieValue(name = "login-token",required = false) String token){
        service.logout(token);
        ResponseCookie cookie=ResponseCookie.from("login-token","").path("/").maxAge(0).httpOnly(true).build();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body("Çıkış Yapıldı");
    }
}

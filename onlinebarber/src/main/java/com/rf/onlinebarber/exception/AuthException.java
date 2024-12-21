package com.rf.onlinebarber.exception;

public class AuthException extends RuntimeException {
    public AuthException() {
        super("Şifre Uyumlu değil");
    }
}

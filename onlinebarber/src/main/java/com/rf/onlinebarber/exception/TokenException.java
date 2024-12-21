package com.rf.onlinebarber.exception;

public class TokenException extends RuntimeException{
    public TokenException() {
        super("Geçersiz Token");
    }
}

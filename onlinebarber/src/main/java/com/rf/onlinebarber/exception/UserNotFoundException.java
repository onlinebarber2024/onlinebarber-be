package com.rf.onlinebarber.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){
        super("Kullanıcı bulunamadi");
    }
}

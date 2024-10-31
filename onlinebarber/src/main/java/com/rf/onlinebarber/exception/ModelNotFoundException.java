package com.rf.onlinebarber.exception;

public class ModelNotFoundException extends RuntimeException{
    public ModelNotFoundException() {
        super("Model bulunamadi");
    }
}

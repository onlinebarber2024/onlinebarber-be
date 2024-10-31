package com.rf.onlinebarber.exception;

public class NotAvailableException extends RuntimeException {
    public NotAvailableException() {
        super("Barber şu an musait değil");
    }
}

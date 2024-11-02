package com.rf.onlinebarber.exception;

public class AppointmentNotFoundException extends RuntimeException{
    public AppointmentNotFoundException() {
        super("Randevu bulunamadi");
    }
}

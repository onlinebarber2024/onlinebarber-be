package com.rf.onlinebarber.exception;

public class AppointmentConflictException extends RuntimeException{
    public AppointmentConflictException() {
        super("Bu tarihte başka yerde randevunuz gözüküyor");
    }
}

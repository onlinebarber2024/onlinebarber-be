package com.rf.onlinebarber.model;

public enum Role {
    ROLE_BARBER("BARBER"),ROLE_CUSTOMER("CUSTOMER");
    private String val;
    Role(String val){
        this.val=val;
    }
}

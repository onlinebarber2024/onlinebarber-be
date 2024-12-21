package com.rf.onlinebarber.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_BARBER("BARBER"),ROLE_CUSTOMER("CUSTOMER");
    private String val;
    Role(String val){
        this.val=val;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}

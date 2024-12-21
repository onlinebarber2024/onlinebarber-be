package com.rf.onlinebarber.dto.converter;

import com.rf.onlinebarber.dto.UserDto;
import com.rf.onlinebarber.model.BaseUser;

public class UserConverter implements Converter<BaseUser, UserDto>{
    @Override
    public UserDto convert(BaseUser user) {
        return UserDto.builder().role(user.getRole()).id(user.getId()).name(user.getName()).phoneNumber(user.getPhoneNumber())
                .email(user.getEmail()).build();
    }
}

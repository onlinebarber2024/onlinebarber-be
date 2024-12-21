package com.rf.onlinebarber.dto.converter;

import com.rf.onlinebarber.dto.BarberDto;
import com.rf.onlinebarber.model.Barber;

public class BarberConverter implements Converter<Barber, BarberDto> {

    @Override
    public BarberDto convert(Barber barber) {
        return BarberDto.builder().name(barber.getName()).id(barber.getId()).phoneNumber(barber.getPhoneNumber()).email(barber.getEmail())
                .build();
    }
}

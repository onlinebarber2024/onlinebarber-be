package com.rf.onlinebarber.dto.converter;

import com.rf.onlinebarber.dto.AppointmentDto;
import com.rf.onlinebarber.model.Appointment;

public class AppointmentConverter implements Converter<Appointment, AppointmentDto>{
    private final CustomerConverter customerConverter=new CustomerConverter();
    private final ModelConverter modelConverter=new ModelConverter();
    @Override
    public AppointmentDto convert(Appointment appointment) {
        return AppointmentDto.builder().dateTime(appointment.getDateTime()).model(modelConverter.convert(appointment.getModel()))
                .id(appointment.getId()).customer(customerConverter.convert(appointment.getCustomer())).build();
    }
}

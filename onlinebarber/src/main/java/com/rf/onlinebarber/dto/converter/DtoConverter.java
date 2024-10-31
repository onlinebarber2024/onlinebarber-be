package com.rf.onlinebarber.dto.converter;

import com.rf.onlinebarber.dto.AppointmentDto;
import com.rf.onlinebarber.dto.BarberDto;
import com.rf.onlinebarber.dto.CustomerDto;
import com.rf.onlinebarber.dto.ModelDto;
import com.rf.onlinebarber.model.Appointment;
import com.rf.onlinebarber.model.Barber;
import com.rf.onlinebarber.model.Customer;
import com.rf.onlinebarber.model.ShavingModel;
import org.springframework.stereotype.Component;



@Component
public class DtoConverter {
    public BarberDto convertBarber(Barber barber){
        return BarberDto.builder().name(barber.getName()).id(barber.getId()).phoneNumber(barber.getPhoneNumber()).email(barber.getEmail())
                .build();
    }
    public ModelDto convertModel(ShavingModel model){
        return ModelDto.builder().id(model.getId()).image(model.getImage()).barber(convertBarber(model.getBarber()))
                .price(model.getPrice()).name(model.getName()).build();
    }
    public CustomerDto convertCustomer(Customer customer){
        return CustomerDto.builder().phoneNumber(customer.getPhoneNumber())
                .id(customer.getId()).email(customer.getEmail()).name(customer.getName()).build();
    }

    public AppointmentDto convertAppointment(Appointment appointment) {
        return AppointmentDto.builder().dateTime(appointment.getDateTime()).model(convertModel(appointment.getModel()))
                .id(appointment.getId()).customer(convertCustomer(appointment.getCustomer())).build();
    }
}

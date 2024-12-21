package com.rf.onlinebarber.dto.converter;

import com.rf.onlinebarber.dto.*;
import com.rf.onlinebarber.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class DtoConverter {
    private final DtoConverterFactory factory ;

    public BarberDto convertBarber(Barber barber) {
        return (BarberDto) factory.getConverter(Barber.class).convert(barber);
    }

    public ModelDto convertModel(ShavingModel model) {
        return (ModelDto) factory.getConverter(ShavingModel.class).convert(model);
    }

    public CustomerDto convertCustomer(Customer customer) {
        return (CustomerDto) factory.getConverter(Customer.class).convert(customer);
    }

    public AppointmentDto convertAppointment(Appointment appointment) {
        return (AppointmentDto) factory.getConverter(Appointment.class).convert(appointment);
    }
    public UserDto convertUser(BaseUser user){
        return (UserDto) factory.getConverter(BaseUser.class).convert(user);
    }
}

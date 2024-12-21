package com.rf.onlinebarber.dto.converter;

import com.rf.onlinebarber.model.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class DtoConverterFactory {
    private final Map<Class<?>, Converter<?, ?>> converters = new HashMap<>();

    public DtoConverterFactory() {
        converters.put(Barber.class, new BarberConverter());
        converters.put(ShavingModel.class, new ModelConverter());
        converters.put(Customer.class, new CustomerConverter());
        converters.put(Appointment.class, new AppointmentConverter());
        converters.put(BaseUser.class,new UserConverter());
    }

    @SuppressWarnings("unchecked")
    public <T, U> Converter<T, U> getConverter(Class<T> sourceClass) {
        return (Converter<T, U>) converters.get(sourceClass);
    }
}

package com.rf.onlinebarber.dto.converter;

import com.rf.onlinebarber.dto.ModelDto;
import com.rf.onlinebarber.model.ShavingModel;

public class ModelConverter implements Converter<ShavingModel, ModelDto> {
    private final BarberConverter barberConverter = new BarberConverter();
    @Override
    public ModelDto convert(ShavingModel model) {
        return ModelDto.builder().id(model.getId()).image(model.getImage()).barber(barberConverter.convert(model.getBarber()))
                .price(model.getPrice()).name(model.getName()).build();
    }
}

package com.rf.onlinebarber.dto.converter;

import com.rf.onlinebarber.dto.CustomerDto;
import com.rf.onlinebarber.model.Customer;

public class CustomerConverter implements Converter<Customer, CustomerDto>{
    @Override
    public CustomerDto convert(Customer customer) {
        return
                CustomerDto.builder().phoneNumber(customer.getPhoneNumber())
                        .id(customer.getId()).email(customer.getEmail()).name(customer.getName()).build();
    }
}

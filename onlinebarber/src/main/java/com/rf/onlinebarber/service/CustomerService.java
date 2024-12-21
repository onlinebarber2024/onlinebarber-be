package com.rf.onlinebarber.service;

import com.rf.onlinebarber.dto.ApiResponse;
import com.rf.onlinebarber.dto.CreateCustomerRequest;
import com.rf.onlinebarber.exception.UserNotFoundException;
import com.rf.onlinebarber.model.Customer;
import com.rf.onlinebarber.model.Role;
import com.rf.onlinebarber.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final PasswordEncoder encoder;

    public ApiResponse<Void> createCustomer(CreateCustomerRequest request) {
        Customer customer=Customer.builder().name(request.getName()).email(request.getEmail()).password(encoder.encode(request.getPassword())).role(Role.ROLE_CUSTOMER).phoneNumber(request.getPhoneNumber()).build();
        repository.save(customer);
        return ApiResponse.ok("Müşteri kayıt edildi");
    }

    public ApiResponse<Void> delete(Long id) {
        if(!repository.existsById(id)) throw new UserNotFoundException();
        repository.deleteById(id);
        return ApiResponse.ok("Müşteri silindi");
    }
    protected Customer findById(Long id){
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}

package com.rf.onlinebarber.controller;

import com.rf.onlinebarber.config.ApiPaths;
import com.rf.onlinebarber.dto.ApiResponse;
import com.rf.onlinebarber.dto.CreateCustomerRequest;
import com.rf.onlinebarber.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.CUSTOMER)
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // kayıt
    @PostMapping(ApiPaths.SAVE)
    public ResponseEntity<ApiResponse<Void>> createCustomer(@Valid @RequestBody CreateCustomerRequest request){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }
    // güncelle
    // sil
    @DeleteMapping(ApiPaths.DELETE)
    public ResponseEntity<ApiResponse<Void>> deleteCustomer(@PathVariable Long id){
        return ResponseEntity.ok(customerService.delete(id));
    }

}

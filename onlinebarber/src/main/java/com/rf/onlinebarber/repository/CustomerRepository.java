package com.rf.onlinebarber.repository;

import com.rf.onlinebarber.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

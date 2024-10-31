package com.rf.onlinebarber.repository;

import com.rf.onlinebarber.model.Appointment;
import com.rf.onlinebarber.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

// repositoryd design pattern
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
     List<Appointment> findByCustomer(Customer customer);

}

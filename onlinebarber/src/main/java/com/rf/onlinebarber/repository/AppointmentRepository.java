package com.rf.onlinebarber.repository;

import com.rf.onlinebarber.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}

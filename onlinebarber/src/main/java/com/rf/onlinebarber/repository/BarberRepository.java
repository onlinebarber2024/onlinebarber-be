package com.rf.onlinebarber.repository;

import com.rf.onlinebarber.model.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber,Long> {
}

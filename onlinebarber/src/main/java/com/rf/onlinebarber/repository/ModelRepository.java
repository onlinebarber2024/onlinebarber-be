package com.rf.onlinebarber.repository;

import com.rf.onlinebarber.model.ShavingModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ModelRepository extends JpaRepository<ShavingModel,Long> {
    List<ShavingModel> findByBarberId(Long barberId);
}

package com.rf.onlinebarber.repository;

import com.rf.onlinebarber.model.ShavingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ShavingModel,Long> {
}

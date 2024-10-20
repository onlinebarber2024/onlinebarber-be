package com.rf.onlinebarber.repository;

import com.rf.onlinebarber.model.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository Design pattern
public interface UserRepository extends JpaRepository<BaseUser,Long> {
   boolean existsByEmail(String email);
}

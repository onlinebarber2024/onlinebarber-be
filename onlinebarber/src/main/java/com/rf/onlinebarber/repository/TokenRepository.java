package com.rf.onlinebarber.repository;

import com.rf.onlinebarber.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token,String> {
}

package com.rf.onlinebarber.service.token;

import com.rf.onlinebarber.model.BaseUser;
import com.rf.onlinebarber.model.Token;
import org.springframework.stereotype.Service;


// strategy design pattern
@Service
public interface TokenService {
     Token createToken(BaseUser user);
     BaseUser verifyToken(String token);
     void logout(String token);
}

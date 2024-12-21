package com.rf.onlinebarber.dto;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto {
    String token;
    UserDto user;
}

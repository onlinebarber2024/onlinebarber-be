package com.rf.onlinebarber.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @Email
    @NotNull
    private String email;
    @NotNull
    private String password;
}


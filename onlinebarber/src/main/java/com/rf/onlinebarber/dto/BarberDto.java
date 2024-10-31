package com.rf.onlinebarber.dto;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BarberDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}

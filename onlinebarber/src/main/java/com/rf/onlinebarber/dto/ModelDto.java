package com.rf.onlinebarber.dto;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModelDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String image;
    private BarberDto barber;
}

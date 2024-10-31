package com.rf.onlinebarber.dto;

import com.rf.onlinebarber.model.Barber;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddModelRequest {
    private String name;
    private BigDecimal price;
    private String image;
}

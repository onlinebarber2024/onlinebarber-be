package com.rf.onlinebarber.dto;
import com.rf.onlinebarber.model.Customer;
import com.rf.onlinebarber.model.ShavingModel;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private Long id;
    private CustomerDto customer;
    private ModelDto model;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateTime;
}

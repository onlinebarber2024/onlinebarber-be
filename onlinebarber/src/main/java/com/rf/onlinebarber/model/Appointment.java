package com.rf.onlinebarber.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment extends BaseEntity {
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private ShavingModel model;

}

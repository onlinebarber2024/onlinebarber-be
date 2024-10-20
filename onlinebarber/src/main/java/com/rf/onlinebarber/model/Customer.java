package com.rf.onlinebarber.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseUser{
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Appointment> appointments;

}

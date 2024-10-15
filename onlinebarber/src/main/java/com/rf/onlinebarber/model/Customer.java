package com.rf.onlinebarber.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseUser{
    @OneToMany(cascade = CascadeType.ALL)
    private List<Appointment> appointments;

}

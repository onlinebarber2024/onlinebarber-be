package com.rf.onlinebarber.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ShavingModel extends BaseEntity {
   private String name;
   private BigDecimal price;
   private String image;
   @ManyToOne
   private Barber barber;
   @OneToMany(mappedBy = "model",cascade = CascadeType.ALL)
   private List<Appointment> appointments;
}

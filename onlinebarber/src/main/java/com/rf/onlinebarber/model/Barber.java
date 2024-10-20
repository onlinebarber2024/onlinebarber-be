package com.rf.onlinebarber.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Barber extends BaseUser {
    @OneToMany(mappedBy = "barber",cascade = CascadeType.ALL)
    private List<ShavingModel> models;
}

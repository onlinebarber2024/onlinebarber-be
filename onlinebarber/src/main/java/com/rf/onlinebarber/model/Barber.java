package com.rf.onlinebarber.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Barber extends BaseUser {
    @OneToMany(cascade = CascadeType.ALL)
    private List<ShavingModel> models;
}

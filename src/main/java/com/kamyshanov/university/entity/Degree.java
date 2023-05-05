package com.kamyshanov.university.entity;

import lombok.Setter;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import jakarta.persistence.*;

@Entity
@Table(name = "degree")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    @OneToOne(mappedBy = "degree")
    Lector lector;
}

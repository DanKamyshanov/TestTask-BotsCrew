package com.kamyshanov.university.entity;

import lombok.Setter;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lector")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    @OneToOne
    @JoinColumn(name = "degree_id")
    Degree degree;
    @ManyToMany(mappedBy = "lectors")
    Set<Department> departments = new HashSet<>();
}

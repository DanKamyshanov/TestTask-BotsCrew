package com.kamyshanov.university.entity;

import lombok.Setter;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinTable
    int id;
    String name;
    String head;
    BigDecimal averageSalary;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "department_lectors", joinColumns = {@JoinColumn(name = "department_id")},
            inverseJoinColumns = {@JoinColumn(name = "lector_id")})
    Set<Lector> lectors = new HashSet<>();
}

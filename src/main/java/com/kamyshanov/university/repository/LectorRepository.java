package com.kamyshanov.university.repository;

import com.kamyshanov.university.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LectorRepository extends JpaRepository<Lector, Integer> {

    List<Lector> findAll();
    List<Lector> findLectorsByDepartmentsId(int id);
}

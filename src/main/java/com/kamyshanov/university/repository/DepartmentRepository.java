package com.kamyshanov.university.repository;

import com.kamyshanov.university.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findDepartmentByName(String name);
    List<Department> findAll();
}

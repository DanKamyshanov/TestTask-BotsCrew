package com.kamyshanov.university.service;

import com.kamyshanov.university.entity.Department;
import com.kamyshanov.university.entity.Lector;
import com.kamyshanov.university.repository.DepartmentRepository;
import com.kamyshanov.university.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public void setDepartmentRepository(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    private LectorRepository lectorRepository;

    @Autowired
    public void setLectorRepository(LectorRepository lectorRepository){
        this.lectorRepository = lectorRepository;
    }

    public void printHeadOfDepartment(String departmentName){
        Department department = departmentRepository.findDepartmentByName(departmentName);
        System.out.println("Head of " + departmentName + " department is " + department.getHead());
    }

    public void printStatistics(String departmentName) {
        int assistants = 0;
        int associates = 0;
        int professors = 0;
        Department department = departmentRepository.findDepartmentByName(departmentName);
        List<Lector> lectors = lectorRepository.findLectorsByDepartmentsId(department.getId());
        for (Lector lector : lectors) {
            switch (lector.getDegree().getName()) {
                case "Assistant" -> assistants++;
                case "Associate professor" -> associates++;
                case "Professor" -> professors++;
            }
        }
        System.out.printf("assistants - %d.\n associate professors - %d.\n professors - %d.\n",
                assistants, associates, professors);
    }

    public void printAverageSalary(String departmentName){
        Department department = departmentRepository.findDepartmentByName(departmentName);
        System.out.println("The average salary of " + department.getName() +
                " is " + department.getAverageSalary());
    }

    public void printEmployeeCount(String departmentName){
        Department department = departmentRepository.findDepartmentByName(departmentName);
        List<Lector> lectors = lectorRepository.findLectorsByDepartmentsId(department.getId());
        System.out.println(lectors.size());
    }

    public void printGlobalSearchResult(String query){
        List<Lector> lectors = lectorRepository.findAll();
        for(Lector lector : lectors){
            if(lector.getName().contains(query)){
                System.out.println(lector.getName());
            }
        }
    }
}

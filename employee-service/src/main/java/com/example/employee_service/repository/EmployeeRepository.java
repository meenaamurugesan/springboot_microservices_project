package com.example.employee_service.repository;

import com.example.employee_service.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employees= new ArrayList<>();

    public Employee add(Employee employee){
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id){
        return employees.stream()
                .filter(a -> Long.valueOf(a.id()).equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findByDepartmentId(Long departmentId){
        return employees.stream()
                .filter(a -> Long.valueOf(a.departmentId()).equals(departmentId))
                .toList();
    }
    public List<Employee> findAll(){
        return employees;
    }
}

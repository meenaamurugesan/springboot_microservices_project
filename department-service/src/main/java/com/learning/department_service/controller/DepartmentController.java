package com.learning.department_service.controller;

import com.learning.department_service.client.EmployeeClient;
import com.learning.department_service.model.Department;
import com.learning.department_service.repository.DepartmentRepository;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger logger= LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department){
        logger.info("Department add: {}", department);
        return repository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll(){
        logger.info("Department find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        logger.info("Department find: id={}", id);
        return repository.findById(id);
    }


    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        logger.info("Department find");
        List<Department> departments=repository.findAll();
        departments.forEach(department -> department.setEmployees(employeeClient.findByDepartmentId(department.getId())));
        return departments;
    }

}

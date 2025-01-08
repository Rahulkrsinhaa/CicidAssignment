package com.assignment.demoAssignment.controller;

import com.assignment.demoAssignment.model.Employee;
import com.assignment.demoAssignment.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Endpoint to save a list of employees
    @PostMapping("/save")
    public void saveEmployees(@RequestBody List<Employee> employeeList) {
        employeeService.saveEmployees(employeeList);
    }
}

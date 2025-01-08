package com.assignment.demoAssignment.service;

import com.assignment.demoAssignment.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    // Method to save a list of employees
    public void saveEmployees(List<Employee> employeeList) {
        employees.addAll(employeeList);
    }

    // Method to get the list of employees (for testing purposes)
    public List<Employee> getEmployees() {
        return employees;
    }
}

package com.assignment.demoAssignment.EmployeeServiceTest;
import com.assignment.demoAssignment.model.Employee;
import com.assignment.demoAssignment.service.EmployeeService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeServiceTest {

    @Test
    void testSaveAndRetrieveEmployees() {
        EmployeeService employeeService = new EmployeeService();

        // Save an employee
        Employee employee = new Employee("1", "John Doe", "Engineering");
        employeeService.saveEmployee(employee);

        // Retrieve employees
        List<Employee> employees = employeeService.getAllEmployees();

        assertEquals(1, employees.size());
        assertTrue(employees.contains(employee));
    }
}

package com.assignment.demoAssignment.employeeServiceTest;

import com.assignment.demoAssignment.model.Employee;
import com.assignment.demoAssignment.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private EmployeeService employeeService;
    private EmployeeService mockEmployeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
        mockEmployeeService = Mockito.mock(EmployeeService.class);
    }

    @Test
    void testSaveEmployees() {
        // Create mock employees
        Employee emp1 = new Employee("John", 30, "Developer");
        Employee emp2 = new Employee("Jane", 28, "Designer");

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);

        // Call the saveEmployees method
        employeeService.saveEmployees(employees);

        // Verify that the employees were saved
        List<Employee> savedEmployees = employeeService.getEmployees();
        assertEquals(2, savedEmployees.size());
        assertTrue(savedEmployees.contains(emp1));
        assertTrue(savedEmployees.contains(emp2));
    }

    @Test
    void testSaveEmployees_Mock() {
        // Mock list of employees
        Employee emp1 = new Employee("John", 30, "Developer");
        Employee emp2 = new Employee("Jane", 28, "Designer");

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);

        // Mock behavior of saveEmployees
        mockEmployeeService.saveEmployees(employees);
        Mockito.verify(mockEmployeeService).saveEmployees(employees);
    }
}

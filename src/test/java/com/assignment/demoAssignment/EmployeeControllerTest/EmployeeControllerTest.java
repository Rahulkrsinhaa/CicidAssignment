package com.assignment.demoAssignment.EmployeeControllerTest;

import com.assignment.demoAssignment.controller.EmployeeController;
import com.assignment.demoAssignment.model.Employee;
import com.assignment.demoAssignment.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class EmployeeControllerTest {
    private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void testSaveEmployees() throws Exception {
        // Create employee list
        Employee emp1 = new Employee("John", 30, "Developer");
        Employee emp2 = new Employee("Jane", 28, "Designer");

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);

        // Perform POST request and verify status
        mockMvc.perform(post("/employees/save")
                        .contentType("application/json")
                        .content("[{\"name\":\"John\",\"age\":30,\"position\":\"Developer\"},{\"name\":\"Jane\",\"age\":28,\"position\":\"Designer\"}]"))
                .andExpect(status().isOk());

        // Verify that the saveEmployees method was called
        verify(employeeService).saveEmployees(employees);
    }
}

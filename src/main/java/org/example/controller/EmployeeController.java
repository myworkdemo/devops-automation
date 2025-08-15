package org.example.controller;

import org.example.exception.handler.EmployeeNotFoundException;
import org.example.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private static List<Employee> employees = new ArrayList<>();

    public EmployeeController(){
        getEmployees();
    }

    @GetMapping
    public ResponseEntity<List<Employee>> fetchEmployees() {
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Employee> fetchEmployees(@PathVariable Long empId) {
        Employee employee = employees.stream().filter(emp -> emp.getEmpId().equals(empId))
                .findFirst().orElseThrow(() -> new EmployeeNotFoundException("Employee ID with " + empId + " Not Found"));
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee =
                new Employee(employee.getEmpName(), employee.getEmpAddress(), employee.getEmpDepartment(), employee.getSalary());
        newEmployee.setEmpId(employees.getLast().getEmpId() + 1);
        employees.add(newEmployee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    private List<Employee> getEmployees() {
        employees.add(new Employee(1L, "John Doe", "New York", "IT", 75000));
        employees.add(new Employee(2L, "Jane Smith", "Los Angeles", "HR", 68000));
        employees.add(new Employee(3L, "Michael Brown", "Chicago", "Finance", 82000));
        employees.add(new Employee(4L, "Emily Davis", "Houston", "Marketing", 72000));
        employees.add(new Employee(5L, "David Wilson", "Phoenix", "IT", 76000));
        employees.add(new Employee(6L, "Sarah Johnson", "Philadelphia", "Operations", 70000));
        employees.add(new Employee(7L, "Daniel White", "San Antonio", "Finance", 81000));
        employees.add(new Employee(8L, "Laura Martinez", "San Diego", "HR", 69000));
        employees.add(new Employee(9L, "James Taylor", "Dallas", "IT", 77000));
        employees.add(new Employee(10L, "Olivia Anderson", "San Jose", "Marketing", 73000));
        return employees;
    }
}

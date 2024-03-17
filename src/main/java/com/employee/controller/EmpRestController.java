package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

import java.util.List;

@RestController
public class EmpRestController {

    @Autowired
    private EmployeeService employeeService;

    // Create
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // Read
    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    // Update
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
       updatedEmployee.setEmpId(id);
       return this.employeeService.updateEmployee(updatedEmployee);
    }

    // Delete
    @DeleteMapping("/employee/{id}")
    public boolean deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }
}

package com.employee.service;

import java.util.List;

import com.employee.model.Employee;


public interface EmployeeService 
{
    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    List < Employee > getAllEmployee();

    Employee getEmployeeById(String employeeId);

    boolean deleteEmployee(String empid);
}

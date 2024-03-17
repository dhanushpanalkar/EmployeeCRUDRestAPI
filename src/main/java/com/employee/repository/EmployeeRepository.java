package com.employee.repository;

import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}

package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.exception.*;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		Optional<Employee> empdb = employeeRepository.findById(employee.getEmpId());
		if(empdb.isPresent()) {
			throw new EmployeeNotFoundException("Employee With ID "+ employee.getEmpId() + "Already Exist");
		}
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
	    Optional<Employee> empdb = employeeRepository.findById(employee.getEmpId());
	    if (empdb.isPresent()) {
	        Employee updatEmployee = empdb.get();
	        updatEmployee.setFirstName(employee.getFirstName());
	        updatEmployee.setLastName(employee.getLastName());
	        updatEmployee.setEmail(employee.getEmail());
	        return employeeRepository.save(updatEmployee);
	    } else {
	        throw new EmployeeNotFoundException("Record not found for id: " + employee.getEmpId());
	    }
	}


	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(String employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> empdb = employeeRepository.findById(employeeId);
		if(empdb.isPresent()) {
			return empdb.get();
		}else {
			throw new EmployeeNotFoundException("Record not found for id: " + employeeId);
		}
	}

	@Override
	public boolean deleteEmployee(String empid) {
		// TODO Auto-generated method stub
		Optional<Employee> empdb = employeeRepository.findById(empid);
		if(empdb.isPresent()) {
			employeeRepository.delete(empdb.get());
			return true;
		}else {
			throw new EmployeeNotFoundException("Record not found for id: " + empid);
		}
	}

}

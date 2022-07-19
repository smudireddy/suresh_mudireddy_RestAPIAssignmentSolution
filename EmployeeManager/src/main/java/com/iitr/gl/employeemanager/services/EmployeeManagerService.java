package com.iitr.gl.employeemanager.services;

import java.util.List;

import com.iitr.gl.employeemanager.entities.Employee;

public interface EmployeeManagerService {
	List<Employee> getAllEmployees();
	Employee fetchEmployeeById(Long employeeId);
	Employee addEmployee(Employee theEmployee);
	Employee updateEmployee(Employee theEmployee);
	Employee removeEmployeeById(Long employeeId);
	
	List<Employee> findEmployeesByFirstName(String searchKey, String orderBy);
}

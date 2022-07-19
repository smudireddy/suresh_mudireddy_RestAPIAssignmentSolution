package com.iitr.gl.employeemanager.repository;

import java.util.List;

import com.iitr.gl.employeemanager.entities.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();
	Employee fetchEmployeeById(Long employeeId);
	void addEmployee(Employee theEmployee);
	void updateEmployee(Employee theEmployee);
	Employee removeEmployeeById(Long employeeId);
	
	List<Employee> findEmployeesByFirstNameContains(String searchKey);
	List<Employee> sortEmployeesByFirstNameInOder(String orderBy);
}

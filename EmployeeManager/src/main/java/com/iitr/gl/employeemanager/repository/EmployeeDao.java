package com.iitr.gl.employeemanager.repository;

import java.util.List;

import com.iitr.gl.employeemanager.entities.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();
}

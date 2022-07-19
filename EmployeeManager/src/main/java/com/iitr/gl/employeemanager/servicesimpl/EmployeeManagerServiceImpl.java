package com.iitr.gl.employeemanager.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iitr.gl.employeemanager.entities.Employee;
import com.iitr.gl.employeemanager.repository.EmployeeDao;

@Service
public class EmployeeManagerServiceImpl implements com.iitr.gl.employeemanager.services.EmployeeManagerService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee fetchEmployeeById(Long employeeId) {
		return employeeDao.fetchEmployeeById(employeeId);
	}

	@Override
	public Employee addEmployee(Employee theEmployee) {
		employeeDao.addEmployee(theEmployee);
		return theEmployee;
	}

	@Override
	public Employee updateEmployee(Employee theEmployee) {
		employeeDao.updateEmployee(theEmployee);
		return theEmployee;
	}

	@Override
	public Employee removeEmployeeById(Long employeeId) {
		 return employeeDao.removeEmployeeById(employeeId);
	}

	@Override
	public List<Employee> findEmployeesByFirstName(String searchKey, String orderBy) {
		return employeeDao.findEmployeesByFirstName(searchKey, orderBy);
	}
}

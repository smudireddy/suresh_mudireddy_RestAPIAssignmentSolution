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

}

package com.iitr.gl.employeemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iitr.gl.employeemanager.services.EmployeeManagerService;
import com.iitr.gl.employeemanager.entities.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeManagerController {
	
	@Autowired
	private EmployeeManagerService employeeManagerService;

	@GetMapping("/greet")
	public String greetTheGuest() {
		return "Hi. How are you Suresh?";
	}
	
	@GetMapping("/employees")
	public List<Employee> fetchEmployeesList() {
		return employeeManagerService.getAllEmployees();
	}
}

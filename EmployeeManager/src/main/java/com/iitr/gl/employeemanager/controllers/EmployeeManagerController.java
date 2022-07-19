package com.iitr.gl.employeemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iitr.gl.employeemanager.services.EmployeeManagerService;
import com.iitr.gl.employeemanager.entities.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeManagerController {
	
	@Autowired
	private EmployeeManagerService employeeManagerService;
	
	// List of Employees
	@RequestMapping(value = {"/employees" }, method = {RequestMethod.GET, RequestMethod.POST})
	public List<Employee> fetchEmployeesList() {
		return employeeManagerService.getAllEmployees();
	}
	
	//5 - Employee record fetch with empID
	@GetMapping("/employees/{empId}")
	public Employee fetchEmployeeDetails(@PathVariable Long empId) {
		return employeeManagerService.fetchEmployeeById(empId);
	}
	
	//6 - Add / Update Employee
	@PostMapping("/employees/add")
	public Employee saveCustomer(@RequestBody Employee theEmployee) {

		Employee employee;

		if (theEmployee.getId() != 0) {

			employee = employeeManagerService.fetchEmployeeById(theEmployee.getId());
			if (employee != null) {
				employee.setEmail(theEmployee.getEmail());
				employee.setFirstName(theEmployee.getFirstName());
				employee.setLastName(theEmployee.getLastName());
				
				employee = employeeManagerService.updateEmployee(employee);
			}
		} else {
			employee = employeeManagerService.addEmployee(theEmployee);
		}		
		return employee;
	}
	
	//7 - Remove employee record by empID
	@DeleteMapping("/employees/{empId}")
	public String removeEmployeeDetails(@PathVariable Long empId) {
		Employee employee = employeeManagerService.removeEmployeeById(empId);
		if(employee != null) {
			return "Deleted employee with id: " + empId; 
		}
		return "No employee record exist with id: " + empId; 
	}
	
	//Search 
	@GetMapping("/employees/search/{searchKey}")
	public List<Employee> searchEmployeesList(@PathVariable String searchKey) {
		return employeeManagerService.findEmployeesByFirstNameContains(searchKey);
	}
	
	//Sort
	@GetMapping("/employees/sort")
	public List<Employee> sortEmployeesListByFirstName(@RequestParam("order") String orderByKey) {
		return employeeManagerService.sortEmployeesByFirstNameInOder(orderByKey);
	}
}

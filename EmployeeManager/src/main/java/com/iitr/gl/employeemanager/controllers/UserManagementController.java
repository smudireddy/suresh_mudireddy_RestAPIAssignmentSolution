package com.iitr.gl.employeemanager.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iitr.gl.employeemanager.entities.Employee;
import com.iitr.gl.employeemanager.entities.GLUser;
import com.iitr.gl.employeemanager.entities.GLUserRole;
import com.iitr.gl.employeemanager.services.UserMaanagementService;

@RestController
@RequestMapping("/api")
public class UserManagementController {

	@Autowired
	private UserMaanagementService userManagementService;
	
	// List of Employees
	@RequestMapping(value = { "/users" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String fetchEmployeesList() {
		
		System.out.println("------>");
		List<GLUser> users = userManagementService.fetchAllUsers();
		
		for(GLUser user:users) {
			user.setPassword("************");
			System.out.println("------> " + user.toString());
		}
		return users.toString();
	}

	@RequestMapping(value = { "/users/accessdenied" }, method = { RequestMethod.PUT, RequestMethod.POST })
	public String showAccessDenied() {
		return "Sorry, you do not have permission.";
	}
	
	@RequestMapping(value = {"/users/add" }, method = {RequestMethod.POST})
	public GLUserRole saveEmployee(@RequestBody GLUserRole userRole) {
		
		System.out.println("-----> " + userRole.toString() );
		userManagementService.addUserRole(userRole); 
		return userRole;
	}
	
	
}

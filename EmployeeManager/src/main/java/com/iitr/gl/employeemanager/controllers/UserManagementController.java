package com.iitr.gl.employeemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iitr.gl.employeemanager.entities.GLUser;
import com.iitr.gl.employeemanager.entities.GLUserRole;
import com.iitr.gl.employeemanager.services.UserMaanagementService;

@RestController
@RequestMapping("/api")
public class UserManagementController {

	@Autowired
	private UserMaanagementService userManagementService;

	@Autowired
	PasswordEncoder passwordEncoder;

	// List of Employees
	@RequestMapping(value = { "/users" }, method = { RequestMethod.GET, RequestMethod.POST })
	public List<GLUser> fetchUsersList() {

		List<GLUser> users = userManagementService.fetchAllUsers();

		for (GLUser user : users) {
			user.setPassword("************");
		}
		return users;
	}

	@RequestMapping(value = { "/users/roles" }, method = { RequestMethod.GET, RequestMethod.POST })
	public List<GLUserRole> fetchUserRolesList() {

		List<GLUserRole> roles = userManagementService.fetchAllRoles();
		return roles;
	}

	@RequestMapping(value = { "/users/accessdenied" }, method = { RequestMethod.GET, RequestMethod.PUT,
			RequestMethod.POST })
	public String showAccessDenied() {
		return "Sorry, you do not have permission.";
	}

	@RequestMapping(value = { "/users/addrole" }, method = { RequestMethod.POST })
	public GLUserRole saveEmployee(@RequestBody GLUserRole userRole) {

		userManagementService.addUserRole(userRole);
		return userRole;
	}

	@RequestMapping(value = { "/users/adduser" }, method = { RequestMethod.POST })
	public GLUser saveEmployee(@RequestBody GLUser user) {

		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		userManagementService.addUser(user);
		return user;
	}
}

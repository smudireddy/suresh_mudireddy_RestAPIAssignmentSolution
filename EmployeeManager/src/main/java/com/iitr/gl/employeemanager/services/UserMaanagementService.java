package com.iitr.gl.employeemanager.services;

import java.util.List;

import com.iitr.gl.employeemanager.entities.GLUser;
import com.iitr.gl.employeemanager.entities.GLUserRole;

public interface UserMaanagementService {

	List<GLUser> fetchAllUsers();
	List<GLUserRole> fetchAllRoles();
	
	void addUserRole(GLUserRole role);
}

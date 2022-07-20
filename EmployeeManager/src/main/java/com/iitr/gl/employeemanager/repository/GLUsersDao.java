package com.iitr.gl.employeemanager.repository;

import java.util.List;

import com.iitr.gl.employeemanager.entities.GLUser;
import com.iitr.gl.employeemanager.entities.GLUserRole;

public interface GLUsersDao {
	
	public List<GLUser> fetchAllUsers();
	public GLUser findUserByName(String userName);
	public void addUser(GLUser user);
	public void deleteUser(GLUser user);
	public void updateUser(GLUser user);
	
	public void addUserRole(GLUserRole role);
	List<GLUserRole> fetchAllUserRoles();
}

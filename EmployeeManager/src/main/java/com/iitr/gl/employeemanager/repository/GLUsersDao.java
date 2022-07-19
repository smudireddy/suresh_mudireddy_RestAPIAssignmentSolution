package com.iitr.gl.employeemanager.repository;

import java.util.List;

import com.iitr.gl.employeemanager.entities.GLUser;

public interface GLUsersDao {
	
	public List<GLUser> fetchAllUsers();
	public GLUser findUserByName(String userName);
	public void addUser(GLUser user);
	public void deleteUser(GLUser user);
	public void updateUser(GLUser user);
}

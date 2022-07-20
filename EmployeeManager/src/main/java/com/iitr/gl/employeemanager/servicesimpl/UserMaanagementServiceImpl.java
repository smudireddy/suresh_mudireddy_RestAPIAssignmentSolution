package com.iitr.gl.employeemanager.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iitr.gl.employeemanager.entities.GLUser;
import com.iitr.gl.employeemanager.entities.GLUserRole;
import com.iitr.gl.employeemanager.repository.GLUsersDao;
import com.iitr.gl.employeemanager.security.GLUserDetails;
import com.iitr.gl.employeemanager.services.UserMaanagementService;

@Service
@Transactional
public class UserMaanagementServiceImpl implements UserDetailsService, UserMaanagementService {

	@Autowired
	private GLUsersDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		GLUser user = userDao.findUserByName(username);
		UserDetails userDetails = new GLUserDetails(user);
		return userDetails;
	}

	@Override
	public List<GLUser> fetchAllUsers() {
		return userDao.fetchAllUsers();
	}

	@Override
	public List<GLUserRole> fetchAllRoles() {
		return userDao.fetchAllUserRoles();
	}

	@Override
	public void addUserRole(GLUserRole role) {
		userDao.addUserRole(role);
	}

	@Override
	public void addUser(GLUser user) {
		userDao.addUser(user);
	}
}

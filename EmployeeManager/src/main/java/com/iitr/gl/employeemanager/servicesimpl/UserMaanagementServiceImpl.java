package com.iitr.gl.employeemanager.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iitr.gl.employeemanager.entities.GLUser;
import com.iitr.gl.employeemanager.repository.GLUsersDao;
import com.iitr.gl.employeemanager.security.GLUserDetails;

@Service
public class UserMaanagementServiceImpl implements UserDetailsService {

	@Autowired
	private GLUsersDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		GLUser user = userDao.findUserByName(username);
		UserDetails userDetails = new GLUserDetails(user);
		return userDetails;
	}
}

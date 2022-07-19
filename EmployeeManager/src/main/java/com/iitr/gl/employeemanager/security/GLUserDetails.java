package com.iitr.gl.employeemanager.security;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.mapping.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.iitr.gl.employeemanager.entities.GLUser;
import com.iitr.gl.employeemanager.entities.GLUserRole;

public class GLUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private GLUser glUser;
	
	public GLUserDetails(GLUser glUser) {
		super();
		this.glUser = glUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return this.glUser.getRoles()
				.stream()
				.map(GLUserRole::getRoleName)
				.map(roleName -> "ROLE_" + roleName)
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toSet());
	}

	@Override
	public String getPassword() {
		return this.glUser.getPassword();
	}

	@Override
	public String getUsername() {
		return this.glUser.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}

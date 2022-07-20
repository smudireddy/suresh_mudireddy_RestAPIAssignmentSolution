package com.iitr.gl.employeemanager.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class GLUserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private long roleId;

	@Column(name = "role_name", nullable = false)
	private String roleName;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", 
    		joinColumns = @JoinColumn(name="role_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
	@JsonIgnore
	private Set<GLUser> glusers = new HashSet<GLUser>();

	public GLUserRole(String roleName, Set<GLUser> glusers) {
		super();
		this.roleName = roleName;
		this.glusers = glusers;
	}

	public GLUserRole() {
		super();
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<GLUser> getGlusers() {

		if (this.glusers == null) {
			this.glusers = new HashSet<>();
		}
		return glusers;
	}

	public void setGlusers(Set<GLUser> glusers) {
		this.glusers = glusers;
	}
}

package com.iitr.gl.employeemanager.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class GLUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;

	@Column(name = "user_name", nullable = false, unique = true)
	private String name;

	@Column(name = "user_password")
	private String password;

	@ManyToMany(mappedBy = "glusers", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Set<GLUserRole> roles = new HashSet<GLUserRole>();

	public GLUser(String name, String password, Set<GLUserRole> roles) {
		super();
		this.name = name;
		this.password = password;
		this.roles = roles;
	}

	public GLUser() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<GLUserRole> getRoles() {
		
		if (this.roles == null){
            this.roles = new HashSet<>();
        }
		return roles;
	}

	public void setRoles(Set<GLUserRole> roles) {
		this.roles = roles;
	}
	
	public void addRole(GLUserRole role) {
		if(this.roles == null) {
			this.roles = new HashSet<GLUserRole>();
		}
		
		this.roles.add(role);
		role.getGlusers().add(this);
	}

	@Override
	public String toString() {
		return "GLUser [id=" + id + ", name=" + name + ", password=" + password + ", roles=" + roles + "]";
	}
}

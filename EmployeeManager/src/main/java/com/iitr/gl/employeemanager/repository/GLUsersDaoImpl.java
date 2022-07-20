package com.iitr.gl.employeemanager.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.iitr.gl.employeemanager.entities.GLUser;
import com.iitr.gl.employeemanager.entities.GLUserRole;

@Repository
public class GLUsersDaoImpl implements GLUsersDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<GLUser> fetchAllUsers() {
		return this.entityManager.createQuery("from GLUser", GLUser.class).getResultList();
	}
	
	public GLUser findUserByName(String userName)
	{
		GLUser user = entityManager
				.createQuery("SELECT u from GLUser u WHERE u.name = :username", GLUser.class)
				.setParameter("username", userName).getSingleResult();
		return user;
	}

	@Override
	public void addUser(GLUser user) {
		entityManager.persist(user);
		entityManager.flush();
	}

	@Override
	public void deleteUser(GLUser user) {
		this.entityManager.remove(user);
	}

	@Override
	public void updateUser(GLUser user) {
		this.entityManager.merge(user);
	}

	@Override
	public void addUserRole(GLUserRole role) {
		entityManager.persist(role);
		entityManager.flush();
	}
}

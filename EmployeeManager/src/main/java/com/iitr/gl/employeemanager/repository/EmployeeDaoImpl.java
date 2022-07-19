package com.iitr.gl.employeemanager.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.iitr.gl.employeemanager.entities.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Employee> getAllEmployees() {
		return entityManager.createQuery("from Employee").getResultList();
	}
	
}

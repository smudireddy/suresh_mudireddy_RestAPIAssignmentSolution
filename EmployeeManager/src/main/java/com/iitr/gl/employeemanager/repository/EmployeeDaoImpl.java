package com.iitr.gl.employeemanager.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	
	@Override
	public Employee fetchEmployeeById(Long employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}
	
	@Override
	public void addEmployee(Employee theEmployee) {
		entityManager.persist(theEmployee);
		entityManager.flush();
	}

	@Override
	public void updateEmployee(Employee theEmployee) {
		entityManager.merge(theEmployee);
		entityManager.flush();
	}

	@Override
	public Employee removeEmployeeById(Long employeeId) {

		Employee employee = entityManager.find(Employee.class, employeeId);
		if (employee != null) {
			entityManager.remove(employee);
		}
		return employee;
	}
	
	@Override
	public List<Employee> findEmployeesByFirstNameContains(String searchKey) {
		String queryStr = "from Employee e where e.firstName like '%" + searchKey + "%' order by e.firstName asc";   
		TypedQuery<Employee> query = entityManager.createQuery(queryStr, Employee.class);
		return query.getResultList();
	}

	@Override
	public List<Employee> sortEmployeesByFirstNameInOder(String orderBy) {
		
		String queryStr = "from Employee e where e.firstName order by e.firstName " + orderBy;   
		TypedQuery<Employee> query = entityManager.createQuery(queryStr, Employee.class);
		return query.getResultList();
	
	}
}


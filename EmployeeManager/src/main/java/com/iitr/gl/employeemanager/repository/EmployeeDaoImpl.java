package com.iitr.gl.employeemanager.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	public List<Employee> findEmployeesByFirstName(String searchKey, String orderBy) {
		
		Query query = entityManager.createQuery("select e from Employee e where e.first_name like '%:searchKey%' ordered by e.first_name :orderBy");
		query.setParameter("searchKey", searchKey);
		query.setParameter("orderedBy", ((orderBy.length() == 0)?"ASC":orderBy));
		return query.getResultList();
	}
}


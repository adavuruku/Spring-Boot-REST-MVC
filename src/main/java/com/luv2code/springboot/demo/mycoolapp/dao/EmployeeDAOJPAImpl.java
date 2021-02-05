package com.luv2code.springboot.demo.mycoolapp.dao;

import java.util.List;


import javax.persistence.EntityManager;

import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.demo.mycoolapp.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{

	/*
	 * This is the JPA implementation 
	 * of the DAO 
	 * anyone of DAO / Hibernate u use is better 
	 * */
	private EntityManager entitymanager; //note that spring boot will generate the Entity manager automatically
	
	//we are using contructor injection here
	// but springallows you to use any injection method - setters / field
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager theEntityManager) {
		entitymanager = theEntityManager;
		
	}
	
	@Override
	public List<Employee> findAll() {
		Query theQuery = 
				entitymanager.createQuery("from Employee");
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
		
	}

	@Override
	public Employee findById(int theId) {
		Employee thEmployee = entitymanager.find(Employee.class, theId);
		return thEmployee;
	}

	@Override
	public void save(Employee thEmployee) {
		
		Employee employee = entitymanager.merge(thEmployee);
		thEmployee.setId(employee.getId());
	}
	
	@Override
	public void deleteById(int theId) {
		Query theQuery = entitymanager.createQuery(
				"delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
				
		theQuery.executeUpdate();
	}

}

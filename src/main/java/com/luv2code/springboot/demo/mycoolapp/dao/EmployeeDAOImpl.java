package com.luv2code.springboot.demo.mycoolapp.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.demo.mycoolapp.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	/*
	 * This is the Hibernate implementation 
	 * of the DAO 
	 * anyone of DAO / Hibernate u use is better 
	 * */
	private EntityManager entitymanager; //note that spring boot will generate the Entity manager automatically
	
	//we are using contructor injection here
	// but springallows you to use any injection method - setters / field
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {
		entitymanager = theEntityManager;
		
	}
	
	@Override
	public List<Employee> findAll() {
		Session currentSession = entitymanager.unwrap(Session.class);
		Query<Employee> theQuery = 
				currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Session currentSession = entitymanager.unwrap(Session.class);
		Employee thEmployee = currentSession.get(Employee.class, theId);
		return thEmployee;
	}

	@Override
	public void save(Employee thEmployee) {
		Session currentSession = entitymanager.unwrap(Session.class);
		currentSession.saveOrUpdate(thEmployee);
	}
	
	@Override
	public void deleteById(int theId) {
		Session currentSession = entitymanager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery(
				"delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
				
		theQuery.executeUpdate();
	}

}

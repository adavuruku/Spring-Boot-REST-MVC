package com.luv2code.springboot.demo.mycoolapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.springboot.demo.mycoolapp.entity.Employee;

@Repository
public interface EmployeeDAO {
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee thEmployee);
	
	public void deleteById(int theId);
}

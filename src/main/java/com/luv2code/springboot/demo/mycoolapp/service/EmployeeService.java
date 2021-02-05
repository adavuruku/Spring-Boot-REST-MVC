package com.luv2code.springboot.demo.mycoolapp.service;

import java.util.List;

import com.luv2code.springboot.demo.mycoolapp.entity.Employee;


public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee thEmployee);
	
	public void deleteById(int theId);
}

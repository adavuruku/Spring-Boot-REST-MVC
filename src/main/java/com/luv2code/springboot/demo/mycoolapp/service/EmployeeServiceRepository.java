package com.luv2code.springboot.demo.mycoolapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.demo.mycoolapp.dao.EmployeeDAO;
import com.luv2code.springboot.demo.mycoolapp.dao.EmployeeRepository;
import com.luv2code.springboot.demo.mycoolapp.entity.Employee;

@Service
public class EmployeeServiceRepository implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public  EmployeeServiceRepository(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		Employee theEmployee = null;
		Optional<Employee> result = employeeRepository.findById(theId);
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Did not find Employee Id : "+theId);
		}
		return theEmployee;
	}

	@Override
	@Transactional
	public void save(Employee thEmployee) {
		employeeRepository.save(thEmployee);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
		
	}

}

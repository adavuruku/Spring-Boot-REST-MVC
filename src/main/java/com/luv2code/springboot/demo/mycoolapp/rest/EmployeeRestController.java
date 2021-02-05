package com.luv2code.springboot.demo.mycoolapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.demo.mycoolapp.dao.EmployeeDAO;
import com.luv2code.springboot.demo.mycoolapp.entity.Employee;
import com.luv2code.springboot.demo.mycoolapp.service.EmployeeService;

@RestController
@RequestMapping("/api/jpa")
public class EmployeeRestController {

	private EmployeeService thEmployeeService;
	
	@Autowired
	public EmployeeRestController(@Qualifier("employeeServiceImpl") EmployeeService thEmployeeService) {
		this.thEmployeeService = thEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return thEmployeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId){
		Employee employee  =  thEmployeeService.findById(employeeId);
		if(employee == null) {
			throw new RuntimeException("Employee Id Not Found : "+employeeId);
		}
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee){
		theEmployee.setId(0);
		thEmployeeService.save(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee){
		thEmployeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String updateEmployee(@PathVariable int employeeId){
		Employee employee = thEmployeeService.findById(employeeId);
		if(employee == null) {
			throw new RuntimeException("Employee Id Not Found : "+employeeId);
		}
		thEmployeeService.deleteById(employeeId);
		return "Deleted Employee Id - " + employeeId;
	}
	
	
	
}


package com.luv2code.springboot.demo.mycoolapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.demo.mycoolapp.entity.Employee;
import com.luv2code.springboot.demo.mycoolapp.service.EmployeeService;


@Controller
@RequestMapping("/mvc")
public class DemoController {
	private List<Employee> allEmployees;
	
	private EmployeeService thEmployeeService;
	
	@Autowired
	public DemoController(@Qualifier("employeeServiceImpl") EmployeeService thEmployeeService) {
		this.thEmployeeService = thEmployeeService;
	}
	
	@PostConstruct
	public void loadData() {
		allEmployees = new ArrayList<Employee>();
		Employee employee1 = new Employee("Saam", "Lee", "sam@gmail.com");
		Employee employee2 = new Employee("Murich", "Coman", "coman@gmail.com");
		Employee employee3 = new Employee("Mabuch", "Heil", "haila@gmail.com");
		
		allEmployees.add(employee1);
		allEmployees.add(employee2);
		allEmployees.add(employee3);
	}
	
	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		theModel.addAttribute("theDate",  new java.util.Date());
		return "helloworld";
	}
	
	@GetMapping("/list")
	public String allEmployee(Model theModel) {
		List<Employee> employees = thEmployeeService.findAll();
		theModel.addAttribute("employees",  employees);
		System.out.println(employees.toString());
		return "list-employee";
	}
	
	@GetMapping("/showFormForAdd")
	public String loadEmployee(Model theModel) {
		Employee employees = new Employee();
		theModel.addAttribute("employee",  employees);
		return "add-employee";
	}
	
	@PostMapping("/save")
	public String addEmployee(@ModelAttribute("employee") Employee empoloyee) {
		thEmployeeService.save(empoloyee);
		return "redirect:list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormFormUpdate(@RequestParam("employeeId") int theId, 
			 Model theModel) {
		Employee employees = thEmployeeService.findById(theId);
		theModel.addAttribute("employee",  employees);
		return "add-employee";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId, 
			 Model theModel) {
		thEmployeeService.deleteById(theId);
		return "redirect:list";
	}
}

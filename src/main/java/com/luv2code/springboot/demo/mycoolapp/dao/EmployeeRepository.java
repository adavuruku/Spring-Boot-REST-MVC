package com.luv2code.springboot.demo.mycoolapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luv2code.springboot.demo.mycoolapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

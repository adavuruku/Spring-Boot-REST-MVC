package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//springboot template FreeMarker, Thymeleaf, Mustache

@RestController
public class FunRestController {
	@Value("${coach.name}")
	String coachName;
	
	@Value("${team.name}")
	String teamName;
	
	@GetMapping("/")
	public String sayHello() {
		
		return "Hello World! Time on Server is : " +LocalDate.now() + 
				"\n"+"Coach Name : " +coachName +"\n" +
				"Team Name :"+ teamName;
	}
	
	@GetMapping("/workout")
	public String startRunning() {
		
		return "Run faster and cover 35KM";
	}
	
	@GetMapping("/fortune")
	public String startFortune() {
		
		return "Today is your lucky day";
	}
}

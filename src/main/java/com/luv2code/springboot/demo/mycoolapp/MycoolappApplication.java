package com.luv2code.springboot.demo.mycoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*@SpringBootApplication(scanBasePackageClasses = {
		"com.luv2code.springboot.demo.mycoolapp",
		"com.sgme.iot.utils"
})*/ //you can specify different package to scan from else it uses the package and sub package of this class
@SpringBootApplication //this annotation compose auto-config, component-scan, configuration etc
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

}

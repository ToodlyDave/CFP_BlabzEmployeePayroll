package com.springRest.EmployeePayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeePayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollApplication.class, args);
		log.info("The application has started! ");
	}

}

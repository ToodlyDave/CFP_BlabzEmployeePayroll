package com.springRest.EmployeePayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.EmployeePayroll.services.IEmployeeService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	@GetMapping(value = { "", "/" })
	public String hello() {
		return employeeService.helloWorld();
	}
}

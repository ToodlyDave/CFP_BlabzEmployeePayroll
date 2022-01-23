package com.springRest.EmployeePayroll.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springRest.EmployeePayroll.entities.Employee;
import com.springRest.EmployeePayroll.repo.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String helloWorld() {
		// TODO Auto-generated method stub
		return "Hello World!";
	}

	@Override
	public Employee getEmployee(String id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeRepository.findById(Long.parseLong(id));
		if (employee.isPresent()) {
			return employee.get();
		} else
			return null;
	}

	@Override
	public Employee postEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> emp = employeeRepository.findById(employee.getId());
		if (emp.isPresent()) {
			return employeeRepository.save(employee);
		}

		return null;
	}

	@Override
	public String deleteEmployee(String id) {
		// TODO Auto-generated method stub
		if (employeeRepository.findById(Long.parseLong(id)).isPresent()) {
			employeeRepository.deleteById(Long.parseLong(id));
			return " Employee record deleted!";
		} else
			return " No such employee record found!";
	}

}

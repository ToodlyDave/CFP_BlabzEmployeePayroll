package com.springRest.EmployeePayroll.repo;

import org.springframework.data.repository.CrudRepository;

import com.springRest.EmployeePayroll.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}

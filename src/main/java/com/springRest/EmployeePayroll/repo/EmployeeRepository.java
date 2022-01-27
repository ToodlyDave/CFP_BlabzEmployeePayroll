package com.springRest.EmployeePayroll.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springRest.EmployeePayroll.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

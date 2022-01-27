package com.springRest.EmployeePayroll.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springRest.EmployeePayroll.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query(value = "SELECT * FROM employee e, employee_department ed WHERE e.id = ed.id AND ed.department = :dept", nativeQuery = true)
	public List<Employee> findEmployeeByDepartment(@Param("dept") String department);
}

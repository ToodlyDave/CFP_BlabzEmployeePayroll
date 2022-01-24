package com.springRest.EmployeePayroll.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.springRest.EmployeePayroll.dto.EmployeeDTO;
import com.springRest.EmployeePayroll.dto.ResponseDTO;

public interface IEmployeeService {

	public ResponseEntity<String> helloWorld();

	public ResponseEntity<ResponseDTO> getEmployee(Optional<String> id);

	public ResponseEntity<ResponseDTO> postEmployee(EmployeeDTO employee);

	public ResponseEntity<ResponseDTO> updateEmployee(String id, EmployeeDTO employee);

	public ResponseEntity<ResponseDTO> deleteEmployee(String id);

}

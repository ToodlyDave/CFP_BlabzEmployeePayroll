package com.springRest.EmployeePayroll.services;

import org.springframework.http.ResponseEntity;

import com.springRest.EmployeePayroll.dto.ResponseDTO;
import com.springRest.EmployeePayroll.entities.Email;

public interface IMailServices {

	public ResponseEntity<ResponseDTO> sendEmail(Email email);
	
	public String getLink(String tokens);
}

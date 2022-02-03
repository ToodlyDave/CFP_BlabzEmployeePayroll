package com.springRest.EmployeePayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

// This is the dto for the response. We will return an object of this dto with every response.

@Getter
@AllArgsConstructor
public class ResponseDTO {

	private @NonNull String message;
	Object data;
	String token;

}

package com.springRest.EmployeePayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class ResponseDTO {

	private @NonNull String message;
	Object data;

}

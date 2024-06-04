package com.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3057941881192202349L;
	private String errorDescription;
	
}

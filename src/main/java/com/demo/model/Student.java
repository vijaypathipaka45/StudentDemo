package com.demo.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -433661816442077298L;

	private long studentId;
	private String studentName;
	private LocalDate dateOfBirth;
	private LocalDate joiningDate;
	private int classStandard;
		
}

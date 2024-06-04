package com.demo.util;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.demo.exception.StudentException;
import com.demo.model.Student;

@Component
public class StudentUtils {

	public void validateRequest(Student student) throws StudentException {
		
		if(student !=null) {
			if(!Objects.nonNull(student.getStudentName()) || !Objects.nonNull(student.getClassStandard())) {
				throw new StudentException("Please provide student name and classStandard");
			}
		}
		
	}

	public void validateRequestParams(Long studentId, String studentName, Integer classStandard) throws StudentException {
		
		if(!Objects.nonNull(studentId) || !Objects.nonNull(studentName)||!Objects.nonNull(classStandard)) {
			
			throw new StudentException("Please provide studentId or studentName or classStandard ");
		}
		
	}

}

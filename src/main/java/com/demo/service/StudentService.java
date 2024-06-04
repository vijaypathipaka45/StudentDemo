package com.demo.service;

import java.util.List;

import com.demo.model.Student;

public interface StudentService {

	void saveOrUpdateStudent(Student student)throws Exception;



	List<Student> getStudentdetails(Long studentId, String studentName, Integer classStandard)throws Exception;

}

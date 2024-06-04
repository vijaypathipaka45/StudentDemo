package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.StudentException;
import com.demo.model.Student;
import com.demo.service.StudentService;

import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@PostMapping(value="saveStudent",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveStudent(@RequestBody Student student) throws Exception {
		try {
			
		studentService.saveOrUpdateStudent(student);
		
		return new ResponseEntity<>("Student Detials added to DB", HttpStatus.OK);
		}
		catch(StudentException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	@PostMapping(value="updateStudent",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateStudent(@RequestBody Student student) throws Exception {
		try {
			
			studentService.saveOrUpdateStudent(student);
			
			return new ResponseEntity<>("Student Detials Updated to DB", HttpStatus.OK);
			}
			catch(StudentException e) {
				throw e;
			}
			catch(Exception e) {
				throw e;
			}
	}
	
	
	@GetMapping(value="getStudentDettails",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> getStudentdetails(@PathVariable Long studentId,@PathVariable String studentName,@PathVariable Integer classStandard) throws Exception {
		try {
		List<Student> list=studentService.getStudentdetails(studentId,studentName,classStandard);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
		}
		catch(StudentException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	
	

}

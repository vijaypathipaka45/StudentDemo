package com.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.StudentEntity;
import com.demo.exception.StudentException;
import com.demo.model.Student;
import com.demo.repo.StudentRepo;
import com.demo.util.StudentUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo repository;
	
	@Autowired
	private StudentUtils utils;
	
	@Override
	public void saveOrUpdateStudent(Student student) throws Exception {
		try {
			
		utils.validateRequest(student);
		
		StudentEntity entity=entityMapping(student);
		
		StudentEntity s=repository.save(entity);
		
		
		}catch(StudentException e) {
			log.error("while saving or updating got an exception {}",e);
		throw e; 	
		}
		catch(Exception e) {
			log.error("while saving or updating got an exception {}",e);
			throw e;
			
		}
	}

	
	

	@Override
	public List<Student> getStudentdetails(Long studentId, String studentName, Integer classStandard) throws Exception {
		
		try {
			
			utils.validateRequestParams(studentId,studentName,classStandard);
			
			
			
			List<StudentEntity> reponseList=repository.findByIdorStudentNameorClassStandard(studentId,studentName,classStandard);
			if(reponseList !=null && reponseList.size()>0) {
				List<Student> students= reponseList.stream().map(response->{
				  Student student=new Student();
				  student.setStudentId(response.getId());
				  student.setClassStandard(response.getClassStandard());
				  student.setDateOfBirth(response.getDateOfBirth());
				  student.setJoiningDate(response.getJoiningDate());
				  student.setStudentName(response.getStudentName());
			     return student;
			        }).collect(Collectors.toList());
				
				return students;
			}else {
				throw new StudentException("details not found in DB for the given input");
			}
			}catch(StudentException e) {
				log.error("while saving or updating got an exception {}",e);
			throw e; 	
			}
			catch(Exception e) {
				log.error("while saving or updating got an exception {}",e);
				throw e;
				
			}
		
	}

	private StudentEntity entityMapping(Student student) {
		StudentEntity entity=new StudentEntity();
		entity.setClassStandard(student.getClassStandard());
		entity.setDateOfBirth(student.getDateOfBirth());
		entity.setJoiningDate(student.getDateOfBirth());
		entity.setStudentName(student.getStudentName());
		return entity;
	}

}

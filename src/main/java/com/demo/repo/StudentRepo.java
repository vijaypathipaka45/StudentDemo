package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.StudentEntity;

@Repository
public interface StudentRepo extends CrudRepository<StudentEntity, Long> {

	 @Query(nativeQuery = true, 
		    value = "SELECT id,studentName,dateOfBirth,joiningDate,classStandard"
		    		+ "FROM student where id=:studentId or studentName=:studentName or classStandard=:classStandard")
	List<StudentEntity> findByIdorStudentNameorClassStandard(@Param("studentId") long studentId, @Param("studentName") String studentName, @Param("classStandard") int classStandard);
	
	
	

}

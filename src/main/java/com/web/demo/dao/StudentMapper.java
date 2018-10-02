package com.web.demo.dao;

import java.util.List;

import com.web.demo.domain.Student;

public interface StudentMapper {

	List<Student> getAll();
	
	Student getStudentById(Long id);
}

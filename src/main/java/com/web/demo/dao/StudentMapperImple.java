package com.web.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.web.demo.domain.Student;

public class StudentMapperImple implements StudentMapper{

	public List<Student> getAll() {
		Student student = new Student(3l, "qq", 18);
		List<Student> list = new ArrayList<Student>();
		list.add(student);
		return list;
	}

	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return new Student(id, "qq", 18);
	}

}

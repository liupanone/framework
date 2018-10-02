package com.web.demo.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.demo.dao.StudentMapper;
import com.web.demo.domain.Student;
import com.web.demo.utils.DBTools;

public class JdbcDemo {

	
	public static void main(String[] args){
		getAllStudent();
	}
	
	public static void getAllStudent(){
		SqlSession session = DBTools.getSession();
		StudentMapper mappper = session.getMapper(StudentMapper.class);
		try {
			List<Student> students = mappper.getAll();
			System.out.println(students.toString());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.close();
		}
	}
}

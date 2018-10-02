package com.web.demo.test;

import com.web.demo.dao.StudentMapper;
import com.web.demo.domain.Student;
import com.web.demo.proxy.MapperProxy;

public class JdbcProxyDemo {

	public static void main(String[] args){
		MapperProxy proxy = new MapperProxy();
		StudentMapper mapper = proxy.newInstance(StudentMapper.class);
		Student student = mapper.getStudentById(11l);
		System.out.println(student.toString());
		System.out.println(mapper.toString());
	}
}

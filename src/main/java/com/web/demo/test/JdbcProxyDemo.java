package com.web.demo.test;

import java.lang.reflect.Proxy;

import com.web.demo.dao.StudentMapper;
import com.web.demo.dao.StudentMapperImple;
import com.web.demo.domain.Student;
import com.web.demo.proxy.MapperProxy;

public class JdbcProxyDemo {

	public static void main(String[] args) {

		JdbcProxyDemo demo = new JdbcProxyDemo();
		// demo.demoOne();
		demo.demoTwo();

	}

	public void demoOne() {
		StudentMapper mapper = new StudentMapperImple();
		MapperProxy proxy = new MapperProxy(mapper);

		StudentMapper stuProxy = (StudentMapper) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				mapper.getClass().getInterfaces(), proxy);
		Student student = stuProxy.getStudentById(11l);
		System.out.println(student.toString());
		System.out.println(stuProxy.toString());

	}

	public void demoTwo() {
		MapperProxy proxy = new MapperProxy(StudentMapper.class);

		StudentMapper stuProxy = (StudentMapper) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				new Class[] { StudentMapper.class }, proxy);
		Student student = stuProxy.getStudentById(11l);
		System.out.println(student.toString());

		// 会报错
		// System.out.println(stuProxy.toString());

	}

}

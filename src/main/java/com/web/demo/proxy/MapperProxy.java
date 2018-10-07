package com.web.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.web.demo.domain.Student;

public class MapperProxy implements InvocationHandler {

	private Object obj;

	public MapperProxy(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		/*
		 * 疑问，刚开始不太明白的时候看到有人这么写，就给复制过来了，但是发现这一块根本运行不了，因为这个是判断
		 * method的声明位置是否是一个class， 但是如果是一个class,那么invoke方式是不接受该参数的
		 * 
		 * if (Object.class.equals(method.getDeclaringClass())) { return
		 * method.invoke(obj, args); }
		 */

		// return method.invoke(obj, args);
		return new Student(11l, "mike", 26);
	}

}

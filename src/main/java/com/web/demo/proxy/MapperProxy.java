package com.web.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.web.demo.domain.Student;

public class MapperProxy implements InvocationHandler {

	// 第一个<T>表示该方法是泛型方法，第二个T表示返回值类型是T类型。
	public <T> T newInstance(Class<T> clz) {
		return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[] { clz }, this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (Object.class.equals(method.getDeclaringClass())) {
			return method.invoke(this, args);
		}
		return new Student((Long) args[0], "aa", 26);
	}

}

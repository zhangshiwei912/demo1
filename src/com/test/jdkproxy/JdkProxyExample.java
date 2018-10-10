package com.test.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {

	//真实对象
	private Object target=null;
	
	/**
	 * 建立真实对象和代理对象之间的代理关系，并返回代理对象
	 * @param target
	 * @return
	 */
	public Object bind(Object target) {
		this.target=target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);
	}
	
	/**
	 * 代理方法逻辑
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("进入代理逻辑方法");
		System.out.println("在调度真实对象之前的服务");
		Object obj = method.invoke(target, args);
		System.out.println("在调度真实对象之后的服务");
		return obj;
	}

}

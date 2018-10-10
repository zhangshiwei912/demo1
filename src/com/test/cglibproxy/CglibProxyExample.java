package com.test.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyExample implements MethodInterceptor{

	/**
	 * 生成CGLIB代理对象
	 * @param cls   Class类
	 * @return Class类的CGLIB代理对象
	 */
	public Object getProxy(Class cls) {
		Enhancer enhancer=new Enhancer();//CGLIB增强类对象
		enhancer.setSuperclass(cls);//设置增强类型
		enhancer.setCallback(this);//将当前对象设置为代理逻辑对象，当前对象要实现MethodInterceptor
		//生成并返回代理对象
		return enhancer.create();
	}
	
	/**
	 * 代理逻辑方法
	 * @param proxy  代理对象
	 * @param method 方法
	 * @param arg    方法参数
	 * @param methodProxy  方法代理
	 * @return 代理逻辑返回
	 */
	public Object intercept(Object proxy, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		
		System.out.println("调用真实对象之前");
		Object result=methodProxy.invokeSuper(proxy, arg);
		System.out.println("调用真实对象之后");
		return result;
	}

}

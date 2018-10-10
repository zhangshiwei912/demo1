package com.test.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyExample implements MethodInterceptor{

	/**
	 * ����CGLIB�������
	 * @param cls   Class��
	 * @return Class���CGLIB�������
	 */
	public Object getProxy(Class cls) {
		Enhancer enhancer=new Enhancer();//CGLIB��ǿ�����
		enhancer.setSuperclass(cls);//������ǿ����
		enhancer.setCallback(this);//����ǰ��������Ϊ�����߼����󣬵�ǰ����Ҫʵ��MethodInterceptor
		//���ɲ����ش������
		return enhancer.create();
	}
	
	/**
	 * �����߼�����
	 * @param proxy  �������
	 * @param method ����
	 * @param arg    ��������
	 * @param methodProxy  ��������
	 * @return �����߼�����
	 */
	public Object intercept(Object proxy, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		
		System.out.println("������ʵ����֮ǰ");
		Object result=methodProxy.invokeSuper(proxy, arg);
		System.out.println("������ʵ����֮��");
		return result;
	}

}

package com.test.cglibproxy;

public class Test {
	public static void main(String[] args) {
		CglibProxyExample cpe=new CglibProxyExample();
		HelloWorld helloWorld=(HelloWorld) cpe.getProxy(HelloWorld.class);
		helloWorld.sayHello("уехЩ");
	}
}

package com.test.jdkproxy;

public class Test {
	
	
	public static void main(String[] args) {
		JdkProxyExample jdk=new JdkProxyExample();
		HelloWorld proxy=(HelloWorld) jdk.bind(new HelloWorldImpl());
		proxy.sayHelloWorld();
		proxy.sayBye();
	}
}

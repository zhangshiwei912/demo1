package com.test.jdkproxy;

public class HelloWorldImpl implements HelloWorld {

	@Override
	public void sayHelloWorld() {
		System.out.println("Hello World!!!");
	}

	@Override
	public void sayBye() {
		System.out.println("Bye Bye!!!");
	}

}

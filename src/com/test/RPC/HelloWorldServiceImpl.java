package com.test.RPC;

public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "Hello! " + name;
	}

}

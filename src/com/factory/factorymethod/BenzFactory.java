package com.factory.factorymethod;

public class BenzFactory implements CarFactory{

	@Override
	public Car getCar() {
		return new Benz();
	}

}

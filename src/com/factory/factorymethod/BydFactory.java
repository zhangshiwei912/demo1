package com.factory.factorymethod;

public class BydFactory implements CarFactory{

	@Override
	public Car getCar() {
		return new Byd();
	}

}

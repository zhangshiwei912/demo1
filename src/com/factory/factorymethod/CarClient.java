package com.factory.factorymethod;

public class CarClient {

	public static void main(String[] args) {
		Car c1=new AudiFactory().getCar();
		Car c2=new BydFactory().getCar();
		Car c3=new BenzFactory().getCar();
		
		c1.run();
		c2.run();
		c3.run();
	}
}

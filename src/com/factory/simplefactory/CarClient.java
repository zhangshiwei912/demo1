package com.factory.simplefactory;

public class CarClient {
	public static void main(String[] args) {
		Car c1=CarFactory.getAudi();
		Car c2=CarFactory.getByd();
		c1.run();
		c2.run();
	}
}

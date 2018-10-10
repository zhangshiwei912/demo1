package com.factory.simplefactory;

public class CarFactory {
	public static Car getAudi() {
		return new Audi();
	}
	
	public static Car getByd() {
		return new Byd();
	} 
}

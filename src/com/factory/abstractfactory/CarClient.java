package com.factory.abstractfactory;

public class CarClient {
	public static void main(String[] args) {
		CarFactory c1=new LuxuryCarFactory();
		CarFactory c2=new LowCarFactory();
		
		Engine engine = c1.createEngine();
		Seat seat = c1.createSeat();
		Tyre tyre = c1.createTyre();
		engine.run();
		seat.message();
		tyre.revolve();
	}
}

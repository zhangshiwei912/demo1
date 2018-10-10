package com.factory.abstractfactory;

public class LowCarFactory implements CarFactory{

	@Override
	public Engine createEngine() {
		return new LuxuryEngine();
	}

	@Override
	public Tyre createTyre() {
		return new LuxuryTyre();
	}

	@Override
	public Seat createSeat() {
		return new LuxurySeat();
	}

}

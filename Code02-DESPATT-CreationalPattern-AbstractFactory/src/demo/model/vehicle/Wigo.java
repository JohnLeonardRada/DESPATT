package demo.model.vehicle;

import demo.model.engine.Engine;

public class Wigo extends ToyotaVehicle {
	
	/*
	 This is a HAS-A object relationship. The
	 presence of another object inside a class
	 means that class will own the object 
	 that is inside.
	 
	  The statement will become "That 
	  any subclass of ToyotaVehicle, 
	  it has an equivalent engine.".
	 */
	private Engine engine;
	
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	public void viewModel() {
		System.out.println("2021 Toyota Wigo");
		System.out.println("A cute and sarap isingit na car.");

	}

	@Override
	public void viewPrice() {
		System.out.println("Php 630,000.00");
	}
}

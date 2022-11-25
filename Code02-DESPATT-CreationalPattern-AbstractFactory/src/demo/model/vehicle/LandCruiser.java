package demo.model.vehicle;

import demo.model.engine.Engine;

public class LandCruiser extends ToyotaVehicle {

	private Engine engine;
	
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	public void viewModel() {
		System.out.println("2021 Toyota Land Cruiser 4x4");
		System.out.println("A vehicle that can cruise on land.");
	}

	@Override
	public void viewPrice() {
		System.out.println("Php 3,300,000.00");
	}
}


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
	public String viewModel() {
		System.out.println("2021 Toyota Land Cruiser 4x4");
		System.out.println("A vehicle that can cruise on land.");
		return "2021 Toyota Land Cruiser 4x4 <br/> A vehicle "
			+ "that can cruise on land.";
	}

	@Override
	public String viewPrice() {
		System.out.println("Php 3,300,000.00");
		return "Php 3,300,000.00";
	}
}

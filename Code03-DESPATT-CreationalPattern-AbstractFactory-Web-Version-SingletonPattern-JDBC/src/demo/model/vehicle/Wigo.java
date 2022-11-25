package demo.model.vehicle;

import demo.model.engine.Engine;

public class Wigo extends ToyotaVehicle {
	private Engine engine;
	
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	public String viewModel() {
		System.out.println("2021 Toyota Wigo");
		System.out.println("A cute and sarap isingit car.");

		return "2021 Toyota Wigo <br/> A cute and sarap isingit car.";
	}

	@Override
	public String viewPrice() {
		System.out.println("Php 600,000.00");
		return "Php 600,000.00";
	}
}


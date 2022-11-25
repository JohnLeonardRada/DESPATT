package demo.model.vehicle;

import demo.model.engine.Engine;

public class HiLux extends ToyotaVehicle {
	private Engine engine;
	
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	public String  viewModel() {
		System.out.println("2021 Toyota Hilux");
		System.out.println("A pickup that likes to keep up.");
		
		return "2021 Toyota Hilux A pickup that likes to keep up.";
	}

	@Override
	public String viewPrice() {
		System.out.println("Php 950,000.00");
		return "Php 950,000.00";
	}
}

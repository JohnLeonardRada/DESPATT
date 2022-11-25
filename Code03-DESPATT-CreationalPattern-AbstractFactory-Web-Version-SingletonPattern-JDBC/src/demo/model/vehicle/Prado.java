package demo.model.vehicle;

import demo.model.engine.Engine;

public class Prado extends ToyotaVehicle {
	private Engine engine;
	
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	public String viewModel() {
		System.out.println("2021 Toyota Prado 2x4");
		System.out.println("All power that burns Nitrous Oxide - mala The Fast and The Furious.");
		
		return "2021 Toyota Prado 2x4 All power that burns Nitrous Oxide - mala The Fast and The Furious.";
	}

	@Override
	public String viewPrice() {
		System.out.println("Php 4,300,000.00");
		return "Php 4,300,000.00";
	}
}

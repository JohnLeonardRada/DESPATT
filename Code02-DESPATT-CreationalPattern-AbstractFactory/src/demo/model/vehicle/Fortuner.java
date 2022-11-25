package demo.model.vehicle;

import demo.model.engine.*;

public class Fortuner extends ToyotaVehicle {

	private Engine engine;
	
	@Override
	public void viewModel() {
		System.out.println("2021 Toyota Fortuner 4x4");
		System.out.println("All power that can climb Batasan Hills.");
	}

	@Override
	public void viewPrice() {
		System.out.println("Php 1,830,000.00");
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
}	


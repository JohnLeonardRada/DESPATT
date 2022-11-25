package demo.model;

public class Prado extends ToyotaVehicle {

	@Override
	public void viewModel() {
		System.out.println("2021 Toyota Prado 2x4");
		System.out.println("All power that burns Nitrous " +
			"Oxide - mala The Fast and The Furious.");
	}

	@Override
	public void viewPrice() {
		System.out.println("Php 2,300,000.00");
	}
}


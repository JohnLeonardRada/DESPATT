package demo.model;

public class Fortuner extends ToyotaVehicle {
	@Override
	public void viewModel() {
		System.out.println("2021 Toyota Fortuner 4x4");
		System.out.println("All power that can climb " +
			"Batasan Hills.");
	}

	@Override
	public void viewPrice() {
		System.out.println("Php 2,130,000.00");
	}
}


package demo.model;

public class LandCruiser extends ToyotaVehicle {

	@Override
	public void viewModel() {
		System.out.println("2021 Toyota Land Cruiser 4x4");
		System.out.println("A vehicle that can cruise on land.");
	}

	@Override
	public void viewPrice() {
		System.out.println("Php 3,000,000.00");
	}
}


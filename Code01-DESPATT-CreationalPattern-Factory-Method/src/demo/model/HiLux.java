package demo.model;

public class HiLux extends ToyotaVehicle {

	@Override
	public void viewModel() {
		System.out.println("2021 Toyota Hilux");
		System.out.println("A pickup that likes to keep up.");
	}

	@Override
	public void viewPrice() {
		System.out.println("Php 980,000.00");
	}
}


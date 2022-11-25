package model.packing;

public class SamsungGalaxyBudsCase extends AirPods implements Packing{
	
	@Override
	public String name() {
		return "Samsung Galaxy Buds";
	}

	@Override
	public double price() {
		return 1000;
	}

	@Override
	public String pack() {
		return "Box";
	}
	
}

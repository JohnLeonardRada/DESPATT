package model.packing;

public class PixelBudsCase extends AirPods implements Packing{

	@Override
	public String name() {
		return "PixelBuds Case";
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

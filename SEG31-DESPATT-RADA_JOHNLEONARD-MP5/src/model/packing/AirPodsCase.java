package model.packing;

public class AirPodsCase extends AirPods implements Packing{

	@Override
	public String name() {
		return "AirPods Case";
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

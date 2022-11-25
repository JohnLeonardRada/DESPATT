package model.packing;

public class XiaomiEarphoneCase extends AirPods implements Packing{

	@Override
	public String name() {
		return "Xiaomi Earphone Case";
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

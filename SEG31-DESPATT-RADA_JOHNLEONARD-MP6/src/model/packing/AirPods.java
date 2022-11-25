package model.packing;

public abstract class AirPods implements Item{

	@Override
	public Packing packing() {
		return new AirPodsCase();
	}

}

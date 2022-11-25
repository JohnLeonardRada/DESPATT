package model.packing;

public abstract class SamsungGalaxyBuds implements Item{

	@Override
	public Packing packing() {
		return new SamsungGalaxyBudsCase();
	}

}

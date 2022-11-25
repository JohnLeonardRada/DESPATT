package model.packing;

public abstract class PixelBuds implements Item{

	@Override
	public Packing packing() {
		return new PixelBudsCase();
	}

}

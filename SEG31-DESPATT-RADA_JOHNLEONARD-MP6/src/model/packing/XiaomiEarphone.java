package model.packing;

public abstract class XiaomiEarphone implements Item{

	@Override
	public Packing packing() {
		return new XiaomiEarphoneCase();
	}

}

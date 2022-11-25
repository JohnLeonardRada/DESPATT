package design.pattern.creational.builder;

public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
       return new Bottle();
	}

	/*@Override
	public abstract double price();*/
}


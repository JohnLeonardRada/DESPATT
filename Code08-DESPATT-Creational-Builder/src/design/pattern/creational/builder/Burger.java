package design.pattern.creational.builder;

public abstract class Burger implements Item {

	   @Override
	   public Packing packing() {
	      return new Wrapper();
	   }

	   /*@Override
	   public abstract double price();*/
}


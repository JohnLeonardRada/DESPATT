package design.pattern.creational.builder;

public class VeggieBurger extends Burger {

	   @Override
	   public double price() {
	      return 20.0;
	   }

	   @Override
	   public String name() {
	      return "Veggie Burger puro catsup";
	   }
}


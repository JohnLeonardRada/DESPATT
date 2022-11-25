package design.pattern.creational.builder;

public class ChickenBurger extends Burger {

	   @Override
	   public double price() {
	      return 35.0;
	   }

	   @Override
	   public String name() {
	      return "Chicken Burger with fries";
	   }
}


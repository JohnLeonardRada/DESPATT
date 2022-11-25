package design.pattern.creational.builder;

public class BuiderPatternDemo {

	public static void main(String[] args) {	   
	      MealBuilder mealBuilder = new MealBuilder();

	      Meal veggieMeal = mealBuilder.prepareVeggieMeal();
	      System.out.println("Veggie Meal");
	      veggieMeal.showItems();
	      System.out.println("Total Cost: " + veggieMeal.getCost());

	      Meal nonVegMeal = mealBuilder.prepareNonVeggieMeal();
	      System.out.println("\n\nNon-Veggie Meal");
	      nonVegMeal.showItems();
	      System.out.println("Total Cost: " + nonVegMeal.getCost());
	}
}


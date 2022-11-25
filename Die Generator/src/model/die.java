package model;

import java.util.Random;
import java.util.Scanner;

public class die {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
        die dice = new die();
        
        System.out.println("Welcome Traveler!");
        
		while(true) {
			dice.draw();
			System.out.print("Do you want to continue? (Type no to stop the program!)\n");
			String input = scanner.nextLine();
	         if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
	             System.out.println("Come Again!");
	             scanner.close();
	             return;
	         }
		}
		
	}
	
	private void draw() {
		
		int ctr;
		
		Scanner dice = new Scanner(System.in);
		Random first = new Random();
		
		System.out.print("Choose the number of your fate [1-20]: ");
		int fate_number = dice.nextInt();
		System.out.print("Number of sides [1-20]:");
		int sides = dice.nextInt();
		System.out.print("Number of rolls: ");
		int rolls = dice.nextInt();
		
		System.out.println("");
		
		if((fate_number < 1 || fate_number > 20) ) {
			System.out.println("Try Again! Invalid Input!\n");
		}else if(sides < 1 || sides > 20) {
			System.out.println("Try Again! Invalid Input!\n");	
		}else if(rolls < 0) {
			System.out.println("Try Again! Invalid Input!\n");
		}else{
			int last = 0;
			for(ctr = 0; ctr < rolls; ++ctr) {
				int firstDie = first.nextInt(sides) + 1;
				System.out.println("The die rolled on a " + firstDie);
				last = firstDie;
				
			}
			
			System.out.println("\nLast Value: " + last);
			if(last == fate_number) {
				System.out.println("Congratulations! Your fate hase been decided.");
				System.exit(fate_number);
			}else {
				System.out.println("u ded u fckin nub");
			}
		}
	}
}




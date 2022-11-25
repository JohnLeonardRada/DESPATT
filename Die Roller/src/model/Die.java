package model;

import java.util.Random;
import java.util.Scanner;

public class Die {
	 public static void main(String args[]){

			while(true) {
				draw();
				System.out.println("Do you want to continue? (Type no to stop the program!)");


			}
			
	    }
	 
	 private static void draw() {
		 System.out.print("Enter the number of dice: ");
		  
	        // Initializing the Scanner object to read input
	        Scanner input = new Scanner(System.in);
	        int numberOfDice = input.nextInt();
	  
	        // Initializing the Random object for
	        // generating random numbers
	        Random ranNum = new Random();
	  
	        System.out.print("Hey Geek! You rolled: ");
	        int total = 0;
	        int randomNumber = 0;
	  
	        for (int i = 0; i < numberOfDice; i++) {
	  
	            // Generating the random number and storing it
	            // in the 'randomNumber' variable
	            randomNumber = ranNum.nextInt(12) + 1;
	            total = total + randomNumber;
	            System.out.print(randomNumber);
	            System.out.print(" ");
	        }
	  
	        System.out.println("");
	        System.out.println("Total: " + total);
	        input.close();
	        
	        if(total >= 12) {
	        	System.out.println("You've successfully!");
	        }
	 }
}


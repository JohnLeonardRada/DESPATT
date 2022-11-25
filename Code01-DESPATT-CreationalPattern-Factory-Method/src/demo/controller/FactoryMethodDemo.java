package demo.controller;

import demo.model.*;
import demo.utility.*;
import demo.view.*;

public class FactoryMethodDemo {

	public static void main (String args[]){
		//ask the client about the type of vehicle
		String truckTypeInput = Input.getString("preferred vehicle");
		
		//now we create an object based on the 
		//client's preference
		ToyotaVehicle sasakyan = new Factory().getVehicle(truckTypeInput.toUpperCase());
		
		//once the object is created, pass the very
		//same object on View for printing purposes
		Display.viewDetails(sasakyan);
	}
}


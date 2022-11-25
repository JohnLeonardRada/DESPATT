package demo.controller;

import demo.model.vehicle.*;
import demo.model.engine.*;
import demo.utility.*;
import demo.view.*;

public class FactoryMethodDemo {

	public static void main (String args[]){
		
		//ask the client about the type of vehicle
		String truckTypeInput = 
			Input.getString("preferred vehicle");
		
		//now we create an object based on the client's preference
		ToyotaVehicle sasakyan = new VehicleFactory() .getVehicle(truckTypeInput
				.toUpperCase());
		
		//set the engine
		Engine engine = new EngineFactory().getEngine(truckTypeInput);
		
		//set the ownership of the created engine to 
		//the vehicle created
		sasakyan.setEngine(engine);
		
		/*
		 The above code is the same as 
		 sasakyan.setEngine(new EngineFactory() .getEngine(truckTypeInput));
		 */
		
		//once the object is created, pass the very
		//same object on View for printing purposes
		Display.viewDetails(sasakyan);
	}
}



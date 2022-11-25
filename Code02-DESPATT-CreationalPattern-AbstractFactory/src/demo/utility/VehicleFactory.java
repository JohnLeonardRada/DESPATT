package demo.utility;

import demo.model.vehicle.*;
import demo.model.engine.*;

public class VehicleFactory implements AbstractFactory {
	public ToyotaVehicle getVehicle(String input) {
		//type of object that will be returned
		ToyotaVehicle vehicle = null;
		
		switch(input) {
			case "LAND CRUISER":
				vehicle = new LandCruiser(); break;
			case "HILUX":
				vehicle = new HiLux(); break;
			case "PRADO":
				vehicle = new Prado(); break;
			case "WIGO":
				vehicle = new Wigo(); break;
			case "FORTUNER":
				vehicle = new Fortuner(); break;
		}
		return vehicle;
	}

	@Override
	public Engine getEngine(String name) {
		return null;
	}
}

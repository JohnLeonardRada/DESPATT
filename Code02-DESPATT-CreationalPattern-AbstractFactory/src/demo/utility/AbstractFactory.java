package demo.utility;

import demo.model.vehicle.*;
import demo.model.engine.*;

public interface AbstractFactory {

	/*
	 This is the highlight of our discussion where our class contains two factory 
	 methods - one for each product. 
	 */
	ToyotaVehicle getVehicle(String input);
	Engine getEngine(String name);
}


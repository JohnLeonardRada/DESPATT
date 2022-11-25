package demo.utility;

import demo.model.vehicle.*;
import demo.model.engine.*;

public interface AbstractFactory {

	ToyotaVehicle getVehicle(String input);
	Engine getEngine(String name);
}



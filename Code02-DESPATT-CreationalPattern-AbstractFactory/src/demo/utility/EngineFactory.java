package demo.utility;

import demo.model.engine.*;
import demo.model.vehicle.ToyotaVehicle;

public class EngineFactory implements AbstractFactory {
	
	public Engine getEngine(String name) {
		Engine engine = null;
		
		if(name.equalsIgnoreCase("Fortuner")) {
			engine = new FortunerEngine();
		} else if (name.equalsIgnoreCase("HiLux")) {
			engine = new HiLuxEngine();
		} else if(name.equalsIgnoreCase("LandCruiser")) {
			engine = new LandCruiserEngine();
		} else if(name.equalsIgnoreCase("Prado")) {
			engine = new PradoEngine();
		} else if(name.equalsIgnoreCase("Wigo")) {
			engine = new WigoEngine();
		} 
		return engine;
	}

	@Override
	public ToyotaVehicle getVehicle(String input) {
		return null;
	}
}



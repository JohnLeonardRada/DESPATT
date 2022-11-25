package demo.view;

import demo.model.vehicle.*;
import demo.model.engine.*;

public class Display {

	public static void viewDetails(ToyotaVehicle vehicleType) {
		if (vehicleType instanceof Fortuner) {
			Fortuner fortuner = (Fortuner) vehicleType;
			fortuner.viewModel();
			fortuner.viewPrice();
			
			FortunerEngine engine = (FortunerEngine) vehicleType.getEngine();
			engine.diplayEngineType();
			engine.literAndHorsePower();
		} else if (vehicleType instanceof Prado) {
			Prado prado = (Prado) vehicleType;
			prado.viewModel();
			prado.viewPrice();
			
			PradoEngine engine = (PradoEngine) vehicleType.getEngine();
			engine.diplayEngineType();
			engine.literAndHorsePower();
		} else if (vehicleType instanceof LandCruiser) {
			LandCruiser landCruiser = (LandCruiser) vehicleType;
			landCruiser.viewModel();
			landCruiser.viewPrice();
			
			//DO THIS my dear students for the Prado engine
			//continue coding as formative evaluation
		} else if (vehicleType instanceof HiLux) {
			HiLux hilux = (HiLux) vehicleType;
			hilux.viewModel();
			hilux.viewPrice();
			
			//DO THIS my dear students for the HiLux engine
			//continue coding as formative evaluation
		} else if (vehicleType instanceof Wigo) {
			Wigo wigo = (Wigo) vehicleType;
			wigo.viewModel();
			wigo.viewPrice();
			
			//DO THIS my dear students for the Wigo engine
			//continue coding as formative evaluation
		}
	}
}


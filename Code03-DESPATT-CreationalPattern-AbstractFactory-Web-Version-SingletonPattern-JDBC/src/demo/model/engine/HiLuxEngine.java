package demo.model.engine;

public class HiLuxEngine extends Engine {

	@Override
	public String diplayEngineType() {
		System.out.println("An engine for HiLux");
		return "An engine for HiLux";
	}

	@Override
	public String literAndHorsePower() {
		System.out.println("2.5L and  90 HP");
		return "2.5L and  90 HP";
	}
}

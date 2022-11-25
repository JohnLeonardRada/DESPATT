package demo.model.engine;

public class PradoEngine extends Engine {

	@Override
	public String diplayEngineType() {
		System.out.println("An engine for Prado");
		return "An engine for Prado";
	}

	@Override
	public String literAndHorsePower() {
		System.out.println("5L and  150 HP");
		return "5L and  150 HP";
	}
}

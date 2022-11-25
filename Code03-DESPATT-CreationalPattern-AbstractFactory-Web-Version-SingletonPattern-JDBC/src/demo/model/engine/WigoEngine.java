package demo.model.engine;

public class WigoEngine extends Engine {

	@Override
	public String diplayEngineType() {
		System.out.println("An engine for Wigo");
		return "An engine for Wigo";
	}

	@Override
	public String literAndHorsePower() {
		System.out.println("1L and 50 HP. Good for city " +
			"driving. Tipid sa gasolina. Hindi makasalanan.");
		return "1L and 50 HP. Good for city " +
		"driving. Tipid sa gasolina. Hindi makasalanan.";
	}
}



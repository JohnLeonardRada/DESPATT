package demo.model.engine;

public class WigoEngine extends Engine {

	@Override
	public void diplayEngineType() {
		System.out.println("An engine for Wigo");
	}

	@Override
	public void literAndHorsePower() {
		System.out.println("1L and 50 HP. Good for city " +
			"driving. Tipid sa gasolina. Hindi makasalanan.");
	}
}

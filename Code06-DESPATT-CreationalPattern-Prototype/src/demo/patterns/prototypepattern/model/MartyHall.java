package demo.patterns.prototypepattern.model;

public class MartyHall implements Person {

	private final String NAME = "Marty Hall";

    @Override
    public Person clone() {
        return new MartyHall();
    }

    @Override
    public String toString() {
        return NAME;
    }
}

package demo.patterns.prototypepattern.model;

public class LukaDoncic implements Person {

	private final String NAME = "Luka Doncic";

    @Override
    public Person clone() {
        return new LukaDoncic();
    }

    @Override
    public String toString() {
        return NAME;
    }
}


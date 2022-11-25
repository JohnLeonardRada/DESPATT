package demo.patterns.prototypepattern.model;

public class DirkNowitzki implements Person {

	private final String NAME = "Dirk Nowizki";

    @Override
    public Person clone() {
        return new DirkNowitzki();
    }

    @Override
    public String toString() {
        return NAME;
    }
}


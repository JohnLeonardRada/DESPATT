package demo.patterns.prototypepattern.model;

public class JamesGosling implements Person {
	private final String NAME = "James Gosling";

    @Override
    public Person clone(){
        return new JamesGosling();
    }

    @Override
    public String toString() {
        return NAME;
    }
}

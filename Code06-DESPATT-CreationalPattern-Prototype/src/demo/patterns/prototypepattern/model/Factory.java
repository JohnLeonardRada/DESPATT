package demo.patterns.prototypepattern.model;

import java.util.HashMap;
import java.util.Map;

public class Factory {
	/*
	  A HashMap store items in "key/value" pairs, and you can access them 
	  by an index of another type (e.g. a String).

	  One object is used as a key (index) to another object (value). It can 
	  store different types: String keys and Integer values, or the same type, 
	  like: String keys and String values.
	 */
	private static final Map<String, Person> prototypes = new HashMap<>();

	//eager loading/instantiation
    static {
    	System.out.println("inside Factory static");
        prototypes.put("james", new JamesGosling());
        prototypes.put("marty", new MartyHall());
        prototypes.put("dirk", new DirkNowitzki());
        prototypes.put("luka", new LukaDoncic());
    }

    public static Person getPrototype(String type) {
    	System.out.println("inside getPrototype()");
    	try {
            return prototypes.get(type).clone();
        } catch (NullPointerException ex) {
            System.out.println("Prototype with name: " + type + ", doesn't exist");
            return null;
        }
    }
}


package utility;

import java.util.HashMap;
import java.util.Map;

import model.*;
import model.camera.*;

public class PhoneFactory implements AbstractFactory {
	
	public Phone getPhone(String input) {
		Phone phone = null;
		
		switch(input) {
		
		case "GOOGLE PIXEL 4A":
			phone = new GooglePixel4A();
			break;
		case "IPHONE 12 PRO MAX":
			phone = new Iphone12ProMax();
			break;
		case "SAMSUNG GALAXY Z FLIP":
			phone = new SamsungZFlip();
			break;
		case "XIAOMI POCO M3":
			phone = new XiaomiM3();
			break;
		default:
		}
		return phone;
	}
	
	@Override
	public Camera getCamera(String name) {
		return null;
	}
	
	private static final Map<String, CellphoneFactory> prototypes = new HashMap<>();
	static {
		prototypes.put("GOOGLE PIXEL 4A", new GooglePixel4A());
    	prototypes.put("IPHONE 12 PRO MAX", new Iphone12ProMax());
    	prototypes.put("SAMSUNG GALAXY Z FLIP", new SamsungZFlip());
    	prototypes.put("XIAOMI POCO M3", new XiaomiM3());
	}
	
	public static CellphoneFactory getPrototype(String type) {
    	System.out.println("Inside getPrototype()");
    	
    	try {
            return prototypes.get(type).clone();
        } catch (NullPointerException ex) {
            System.out.println("Prototype with name: " + type + ", doesn't exist");
            return null;
        }
    }
}

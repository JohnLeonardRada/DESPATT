package utility;

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
}

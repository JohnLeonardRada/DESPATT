package utility;

import model.Phone;
import model.SamsungZFlip;
import model.GooglePixel4A;
import model.Iphone12ProMax;
import model.XiaomiM3;

public class Factory {
	
	public Phone getPhone(String phoneType) {
		Phone phone = null;
		
		switch(phoneType) {
		
		case "SAMSUNG GALAXY Z FLIP":
			phone = new SamsungZFlip();
			break;
		case "IPHONE 12 PRO MAX":
			phone = new Iphone12ProMax();
			break;
		case "XIAOMI POCO M3":
			phone = new XiaomiM3();
			break;
		case "GOOGLE PIXEL 4A":
			phone = new GooglePixel4A();
			break;
		default:
		}
		return phone;
	}
	
}

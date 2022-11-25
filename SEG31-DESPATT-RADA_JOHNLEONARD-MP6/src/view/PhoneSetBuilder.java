package view;

import model.*;
import model.packing.*;

public class PhoneSetBuilder {

	public PhoneSet googlePixelBuilder(String phoneName) {
		 PhoneSet googlePixelSet = new PhoneSet();
		 Phone phone = new GooglePixel4A();
		 
		 GooglePixel4A googlepixel4a = (GooglePixel4A) phone;
		 googlePixelSet.addItem(googlepixel4a);
		 googlePixelSet.addItem(new PixelBudsCase());
		
		 return googlePixelSet;
	}
	
	public PhoneSet iphone12ProMaxBuilder(String phoneName) {
		PhoneSet iphone12Set = new PhoneSet();
		Phone phone = new Iphone12ProMax();
		
		Iphone12ProMax iphone12promax = (Iphone12ProMax) phone;
		iphone12Set.addItem(iphone12promax);
		iphone12Set.addItem(new AirPodsCase());
		
		return iphone12Set;
	}
	
	public PhoneSet samsungZFlipBuilder(String phoneName) {
		PhoneSet samsungZFlipSet = new PhoneSet();
		Phone phone = new SamsungZFlip();
		
		SamsungZFlip samsungzflip = (SamsungZFlip) phone;
		samsungZFlipSet.addItem(samsungzflip);
		samsungZFlipSet.addItem(new SamsungGalaxyBudsCase());
		
		return samsungZFlipSet;
	}
	
	public PhoneSet xiaomiM3Builder(String phoneName) {
		PhoneSet xiaomiM3Set = new PhoneSet();
		Phone phone = new XiaomiM3();
		
		XiaomiM3 xiaomim3 = (XiaomiM3) phone;
		xiaomiM3Set.addItem(xiaomim3);
		xiaomiM3Set.addItem(new XiaomiEarphoneCase());
		
		return xiaomiM3Set;
	}
	
}

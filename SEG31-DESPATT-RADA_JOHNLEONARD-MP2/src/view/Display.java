package view;

import model.*;
import model.camera.*;

public class Display {
	public static void viewDetails(Phone phoneType) {
		
		if(phoneType instanceof GooglePixel4A) {
			GooglePixel4A googlepixel = (GooglePixel4A) phoneType;
			googlepixel.setItemName();
			googlepixel.setItemPrice();
			googlepixel.setItemSpecs();
			googlepixel.setItemImage();
			
			GooglePixel4ACamera googlepixel4acamera = (GooglePixel4ACamera) phoneType.getCamera();
			googlepixel4acamera.setMegapixels();
			googlepixel4acamera.setScreenSize();
		}else if (phoneType instanceof Iphone12ProMax) {
			Iphone12ProMax iphone12 = (Iphone12ProMax) phoneType;
			iphone12.setItemName();
			iphone12.setItemPrice();
			iphone12.setItemSpecs();
			iphone12.setItemImage();
			
			Iphone12ProMaxCamera iphone12promaxcamera = (Iphone12ProMaxCamera) phoneType.getCamera();
			iphone12promaxcamera.setMegapixels();
			iphone12promaxcamera.setScreenSize();
		}else if (phoneType instanceof SamsungZFlip) {
			SamsungZFlip samsungz = (SamsungZFlip) phoneType;
			samsungz.setItemName();
			samsungz.setItemPrice();
			samsungz.setItemSpecs();
			samsungz.setItemImage();
			
			SamsungZFlipCamera samsungzflipcamera = (SamsungZFlipCamera) phoneType.getCamera();
			samsungzflipcamera.setMegapixels();
			samsungzflipcamera.setScreenSize();
		}else if (phoneType instanceof XiaomiM3) {
			XiaomiM3 xiaomim3 = (XiaomiM3) phoneType;
			xiaomim3.setItemName();
			xiaomim3.setItemPrice();
			xiaomim3.setItemSpecs();
			xiaomim3.setItemImage();
			
			XiaomiM3Camera xiaomim3camera = (XiaomiM3Camera) phoneType.getCamera();
			xiaomim3camera.setMegapixels();
			xiaomim3camera.setScreenSize();
		}
	}
}

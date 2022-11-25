package utility;

import model.Phone;
import model.camera.*;

public class CameraFactory implements AbstractFactory{

	@Override
	public Camera getCamera(String name) {
		Camera camera = null;
		
		if(name.equalsIgnoreCase("Google Pixel 4A")) {
			camera = new GooglePixel4ACamera();
		}else if(name.equalsIgnoreCase("Iphone 12 Pro Max")) {
			camera = new Iphone12ProMaxCamera();
		}else if(name.equalsIgnoreCase("Samsung Galaxy Z Flip")) {
			camera = new SamsungZFlipCamera();
		}else if(name.equalsIgnoreCase("Xiaomi POCO M3")) {
			camera = new XiaomiM3Camera();
		}
		return camera;
	}
	
	@Override
	public Phone getPhone(String input) {
		return null;
	}

	
}

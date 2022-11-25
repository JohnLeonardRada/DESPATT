package utility;

import model.*;
import model.camera.*;

public interface AbstractFactory {
	Phone getPhone(String input);
	Camera getCamera(String name);
}

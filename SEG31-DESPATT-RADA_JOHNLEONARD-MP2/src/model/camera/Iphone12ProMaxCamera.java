package model.camera;

public class Iphone12ProMaxCamera extends Camera {
	
	@Override
	public void setMegapixels() {
		this.megapixels = "Triple(12,12,12)MP, Selfie: 12 MP";
	}

	@Override
	public void setScreenSize() {
		this.screenSize = "6.7-Inches";
	}

	@Override
	public String getMegapixels() {
		return megapixels;
	}

	@Override
	public String getScreenSize() {
		return screenSize;
	}
}

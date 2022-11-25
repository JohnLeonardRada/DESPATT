package model.camera;

public class SamsungZFlipCamera extends Camera {

	@Override
	public void setMegapixels() {
		this.megapixels = "Dual(12,12)MP, Selfie: 10 MP";
	}

	@Override
	public String getMegapixels() {
		return megapixels;
	}
	
	@Override
	public void setScreenSize() {
		this.screenSize = "6.7-Inches";
	}

	@Override
	public String getScreenSize() {
		return screenSize;
	}
	
}

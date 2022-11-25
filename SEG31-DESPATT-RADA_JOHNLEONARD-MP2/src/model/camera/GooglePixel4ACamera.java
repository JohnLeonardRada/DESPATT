package model.camera;

public class GooglePixel4ACamera extends Camera {

	@Override
	public void setMegapixels() {
		this.megapixels = "Dual(16,12.2) MP, Selfie: 8 MP";
	}

	@Override
	public void setScreenSize() {
		this.screenSize = "5.81-Inches";
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

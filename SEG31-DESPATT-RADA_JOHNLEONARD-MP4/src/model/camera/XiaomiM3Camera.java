package model.camera;

public class XiaomiM3Camera extends Camera {

	@Override
	public void setMegapixels() {
		this.megapixels = "Triple(48,2,2)MP, Selfie: 8 MP";
	}
	
	@Override
	public String getMegapixels() {
		return megapixels;
	}

	@Override
	public void setScreenSize() {
		this.screenSize = "6.5-Inches";
	}

	@Override
	public String getScreenSize() {
		return screenSize;
	}
	
}

package model.camera;

public abstract class Camera {
	
	String megapixels;
	String screenSize;
	
	public abstract void setMegapixels();
	public abstract void setScreenSize();
	
	public abstract String getMegapixels();
	public abstract String getScreenSize();
	
 }

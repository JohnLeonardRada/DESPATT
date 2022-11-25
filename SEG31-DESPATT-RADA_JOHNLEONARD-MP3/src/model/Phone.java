package model;

import model.camera.*;

public abstract class Phone {
	
	String itemId;
	String itemName;
	String itemPrice;
	String itemSpecs;
	String itemImage;
	
	public abstract void setItemId();
	public abstract void setItemName();
	public abstract void setItemPrice();
	public abstract void setItemSpecs();
	public abstract void setItemImage();
	
	public abstract String getItemId();
	public abstract String getItemName();
	public abstract String getItemPrice();
	public abstract String getItemSpecs();
	public abstract String getItemImage();
	
	public abstract void setCamera(Camera camera);
	public abstract Camera getCamera();
	
}

package model;

import model.camera.*;

public abstract class Phone {
	
	String itemId;
	int itemQuantity;
	String itemName;
	double itemPrice;
	String itemSpecs;
	String itemImage;
	
	public abstract void setItemId();
	public abstract void setItemQuantity();
	public abstract void setItemName();
	public abstract void setItemPrice();
	public abstract void setItemSpecs();
	public abstract void setItemImage();
	
	public abstract String getItemId();
	public abstract int getItemQuantity();
	public abstract String getItemName();
	public abstract double getItemPrice();
	public abstract String getItemSpecs();
	public abstract String getItemImage();
	
	public abstract void setCamera(Camera camera);
	public abstract Camera getCamera();
	
}

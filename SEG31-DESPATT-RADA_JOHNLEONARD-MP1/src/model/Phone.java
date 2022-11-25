package model;

public abstract class Phone {
	
	String itemName;
	String itemPrice;
	String itemSpecs;
	String itemImage;
	
	public abstract void setItemName();
	public abstract void setItemPrice();
	public abstract void setItemSpecs();
	public abstract void setItemImage();
	
	public abstract String getItemName();
	public abstract String getItemPrice();
	public abstract String getItemSpecs();
	public abstract String getItemImage();
	
}

package model;

public class SamsungZFlip extends Phone {

	@Override
	public void setItemName() {
		this.itemName = "Samsung Galaxy Z Flip";	
	}

	@Override
	public void setItemPrice() {
		this.itemPrice = "Php 56,000";
	}

	@Override
	public void setItemSpecs() {
		this.itemSpecs = "256GB";
		
	}

	@Override
	public void setItemImage() {
		this.itemImage = "images/z.jpg";
		
	}

	@Override
	public String getItemName() {
		return itemName;
	}

	@Override
	public String getItemPrice() {
		return itemPrice;
	}

	@Override
	public String getItemSpecs() {
		return itemSpecs;
	}

	@Override
	public String getItemImage() {
		return itemImage;
	}
	
}

package model;

public class GooglePixel4A extends Phone {

	@Override
	public void setItemName() {
		this.itemName = "Google Pixel 4A";	
	}

	@Override
	public void setItemPrice() {
		this.itemPrice = "Php 22,000";
	}

	@Override
	public void setItemSpecs() {
		this.itemSpecs = "128GB";
		
	}

	@Override
	public void setItemImage() {
		this.itemImage = "images/g.jpg";
		
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

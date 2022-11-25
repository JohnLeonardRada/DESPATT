package model;

public class Iphone12ProMax extends Phone {

	@Override
	public void setItemName() {
		this.itemName = "Iphone 12 Pro Max";	
	}

	@Override
	public void setItemPrice() {
		this.itemPrice = "Php 81,000";
	}

	@Override
	public void setItemSpecs() {
		this.itemSpecs = "512GB";
		
	}

	@Override
	public void setItemImage() {
		this.itemImage = "images/ip.jpg";
		
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

package model;

import model.camera.Camera;

public class GooglePixel4A extends Phone implements CellphoneFactory{

	private Camera camera;
	
	@Override
	public void setItemId() {
		this.itemId = "1";
	}

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
	public String getItemId() {
		return itemId;
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

	@Override
	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	@Override
	public Camera getCamera() {
		return camera;
	}
	
	@Override
	public CellphoneFactory clone() {
		return new GooglePixel4A();	
	}

	@Override
	public Phone getPhone(String phoneType) {
		return null;
	}
	
	
}

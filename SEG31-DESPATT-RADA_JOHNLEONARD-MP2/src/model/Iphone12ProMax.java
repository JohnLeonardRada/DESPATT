package model;

import model.camera.Camera;

public class Iphone12ProMax extends Phone {

	private Camera camera;
	
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
	
	@Override
	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	@Override
	public Camera getCamera() {
		return camera;
	}
	
}

package model;

import model.camera.Camera;

public class XiaomiM3 extends Phone {

	private Camera camera;	
	
	@Override
	public void setItemName() {
		this.itemName = "Xiaomi POCO M3";	
	}

	@Override
	public void setItemPrice() {
		this.itemPrice = "Php 7,000";
	}

	@Override
	public void setItemSpecs() {
		this.itemSpecs = "128GB";
	}

	@Override
	public void setItemImage() {
		this.itemImage = "images/x.jpg";
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

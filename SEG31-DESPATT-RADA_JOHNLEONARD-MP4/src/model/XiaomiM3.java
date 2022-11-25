package model;

import model.camera.Camera;

public class XiaomiM3 extends Phone implements CellphoneFactory{

	private Camera camera;	
	
	@Override
	public void setItemId() {
		this.itemId = "4";
	}
	@Override
	public String getItemId() {
		return itemId;
	}
	
	@Override
	public void setItemQuantity() {
		this.itemQuantity = 10;
	}
	@Override
	public int getItemQuantity() {
		return itemQuantity;
	}
	
	@Override
	public void setItemName() {
		this.itemName = "Xiaomi POCO M3";	
	}
	@Override
	public String getItemName() {
		return itemName;
	}

	@Override
	public void setItemPrice() {
		this.itemPrice = 7000;
	}
	@Override
	public double getItemPrice() {
		return itemPrice;
	}

	@Override
	public void setItemSpecs() {
		this.itemSpecs = "128GB";
	}
	@Override
	public String getItemSpecs() {
		return itemSpecs;
	}

	@Override
	public void setItemImage() {
		this.itemImage = "images/x.jpg";
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
		return new XiaomiM3();	
	}

	@Override
	public Phone getPhone(String phoneType) {
		return null;
	}
	
}

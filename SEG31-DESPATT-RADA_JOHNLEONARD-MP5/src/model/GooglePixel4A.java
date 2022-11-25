package model;

import model.camera.Camera;
import model.packing.*;

public class GooglePixel4A extends Phone implements CellphoneFactory{

	public GooglePixel4A() {
		setItemId();
		setItemQuantity();
		setItemName();
		setItemPrice();
		setItemSpecs();
		setItemImage();
	}
	
	private Camera camera;
	
	@Override
	public void setItemId() {
		this.itemId = "1";
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
		this.itemName = "Google Pixel 4A";	
	}
	@Override
	public String getItemName() {
		return itemName;
	}
	
	@Override
	public void setItemPrice() {
		this.itemPrice = 22000;
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
		this.itemImage = "images/g.jpg";
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

	@Override
	public String name() {
		return this.itemName;
	}
	
	@Override
	public Packing packing() {
		return new AirPodsCase();
	}
	
	@Override
	public double price() {
		return this.getItemPrice();
	}

}

package model.order;

public class OrderBean {
	int orderID;
	String customerName;
	String itemName;
	int itemQuantity;
	double itemPrice;
	
	public OrderBean(int orderID, String customerName, String itemName, int itemQuantity, double itemPrice) {
		this.orderID = orderID;
		this.customerName = customerName;
		this.itemName = itemName;
		this.itemQuantity  = itemQuantity;
		this.itemPrice = itemPrice;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
}

package model.order;

import java.util.ArrayList;
import java.util.Iterator;

import utility.PurchaseItems;
import utility.SingletonDB;

public class Order implements OrderIterator{
	ArrayList<OrderBean> order;
	
	public Order() {
		order = new ArrayList<OrderBean>();
		int lastItem = SingletonDB.getItems();
			if(SingletonDB.getPhoneName(lastItem) != null) {
				PurchaseItems purchaseitems = SingletonDB.getPhoneItems(lastItem);
				addItem(purchaseitems.getOrderID(), purchaseitems.getCustomerName(), purchaseitems.getItemName(), purchaseitems.getItemQuantity(), purchaseitems.getItemPrice());
			}
	}
	
	public void addItem(int orderID, String customerName, String itemName, int itemQuantity, double itemPrice) {
		OrderBean orderbean = new OrderBean(orderID,customerName, itemName, itemQuantity, itemPrice);
		order.add(orderbean);
	}
	
	public ArrayList<OrderBean> getOrder(){
		return order;
	}
	
	@Override
	public Iterator createIterator() {
		return order.iterator();
	}
	
	
}

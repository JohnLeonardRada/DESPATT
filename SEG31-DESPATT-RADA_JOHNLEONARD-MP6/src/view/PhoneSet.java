package view;

import java.util.ArrayList;

import model.packing.Item;
import model.packing.PackageBean;

public class PhoneSet {
	
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public double getCost(){
	  double cost = 0.0;
	      
	    for (Item item : items) {
	       cost += item.price();
	    }		
	    return cost;
	}
	
	public ArrayList<PackageBean> showItems(){
		ArrayList<PackageBean> packagebean = new ArrayList<PackageBean>();
		
		for (Item item : items) {
			PackageBean pack = new PackageBean();
			pack.setItemName(item.name());
			pack.setItemPrice(item.price());
			pack.setPackaging(item.packing().pack());
			
			packagebean.add(pack);
			
	        System.out.print("Item : " + item.name());
	        System.out.print(", Packing : " + item.packing().pack());
	        System.out.println(", Price : " + item.price());
	    }		
		return packagebean;
	}

}

package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.order.*;
import model.packing.*;
import utility.*;
import view.*;

public class ProcessCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void displayIterator() {
		int count2 = SingletonDB.getItems();

		Order order = new Order();
		
		Iterator<OrderBean> orderIterator = order.createIterator();
		while(orderIterator.hasNext()) {
			OrderBean orderbean = (OrderBean) orderIterator.next();
			
			String phoneName = SingletonDB.getPhoneName(orderbean.getOrderID());
			String itemName = orderbean.getItemName();
			int itemQuantity = orderbean.getItemQuantity();
			double itemPrice = orderbean.getItemPrice();
			System.out.println("Printing Iterator Order!");
			if(phoneName.equalsIgnoreCase("Google Pixel 4A")) {
				
				System.out.println("Item Name: " + itemName);
				System.out.println("Item Quantity: " + itemQuantity);
				System.out.println("Item Price: " + itemPrice);
				
			}else if(phoneName.equalsIgnoreCase("Iphone 12 Pro Max")) {
				
				System.out.println("Item Name: " + itemName);
				System.out.println("Item Quantity: " + itemQuantity);
				System.out.println("Item Price: " + itemPrice);
				
			}else if(phoneName.equalsIgnoreCase("Samsung Galaxy Z Flip")) {
				
				System.out.println("Item Name: " + itemName);
				System.out.println("Item Quantity: " + itemQuantity);
				System.out.println("Item Price: " + itemPrice);
				
			}else if(phoneName.equalsIgnoreCase("Xiaomi POCO M3")) {
				
				System.out.println("Item Name: " + itemName);
				System.out.println("Item Quantity: " + itemQuantity);
				System.out.println("Item Price: " + itemPrice);
				
			}
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String [] itemName = request.getParameterValues("itemName");
		String [] count = request.getParameterValues("count");
		String [] itemPrice = request.getParameterValues("itemPrice");
		String [] itemImage = request.getParameterValues("itemImage");
		
		String owner = request.getParameter("owner");
		String cvv = request.getParameter("cvv");
		String ccn = request.getParameter("ccn");	
		
		CreateFilePDF create = new CreateFilePDF();
		ServletContext context=getServletContext();  
		String file = context.getInitParameter("FilePathing");
		try {		
			
			if(cvv.length() == 3 || cvv.length() == 4 && SingletonDB.Validate(ccn) == true) {		
				
				for(int i = 0; i<itemName.length; i++) {
					System.out.println("------------------------");
					System.out.println("ITEM:" + itemName[i]);
					
					String data_owner = owner;
					String data_itemName = itemName[i];
					String data_itemCount = count[i];
					String data_itemPrice = itemPrice[i];
					String data_itemImage = itemImage[i];
					int data_db_itemQuantity = SingletonDB.getItemQuantity(itemName[i]);					
					
					SingletonDB.insertPurchase(data_owner, data_itemName, data_itemCount, data_itemPrice, data_itemImage);
					SingletonDB.updateQuantity(data_db_itemQuantity, Integer.parseInt(data_itemCount), data_itemName);
					
				}
				
				System.out.println("------------------------");
				System.out.println("Purchase Successful!");
				
				int count1 = SingletonDB.getItems();
				
				for(int i = 1; i <= count1; i++) {
					if(SingletonDB.getPhoneItems(i) != null) {
						PurchaseItems purchaseItems = new PurchaseItems();
						purchaseItems = SingletonDB.getPhoneItems(i);
						
						PhoneSetBuilder phonesetbuilder = new PhoneSetBuilder();
						if(purchaseItems.getItemName().equalsIgnoreCase("Google Pixel 4A")) {
							PhoneSet googlepixelset = new PhoneSet();
							
							googlepixelset = phonesetbuilder.googlePixelBuilder(purchaseItems.getItemName());
							ArrayList<PackageBean> packing = new ArrayList<PackageBean>();
							packing = googlepixelset.showItems();

						}else if(purchaseItems.getItemName().equalsIgnoreCase("Iphone 12 Pro Max")) {
							PhoneSet iphone12set = new PhoneSet();
							
							iphone12set = phonesetbuilder.iphone12ProMaxBuilder(purchaseItems.getItemName());
							ArrayList<PackageBean> packing = new ArrayList<PackageBean>();
							packing = iphone12set.showItems();
							
						}else if(purchaseItems.getItemName().equalsIgnoreCase("Samsung Galaxy Z Flip")) {
							PhoneSet samsunggalaxyset = new PhoneSet();
							
							samsunggalaxyset = phonesetbuilder.samsungZFlipBuilder(purchaseItems.getItemName());
							ArrayList<PackageBean> packing = new ArrayList<PackageBean>();
							packing = samsunggalaxyset.showItems();
							
						}else if(purchaseItems.getItemName().equalsIgnoreCase("Xiaomi POCO M3")) {
							PhoneSet xiaomim3set = new PhoneSet();
							
							xiaomim3set = phonesetbuilder.xiaomiM3Builder(purchaseItems.getItemName());
							ArrayList<PackageBean> packing = new ArrayList<PackageBean>();
							packing = xiaomim3set.showItems();
						}
					}
				}
				
				System.out.println("------------------------");
				displayIterator();
				System.out.println("------------------------");
				create.process(file);
				
				request.getRequestDispatcher("success.jsp").forward(request, response);
				return;
			}else {
				System.out.println("Purchase Failed!");
				request.getRequestDispatcher("failed.jsp").forward(request, response);
			}		
					
		} catch (Exception e) {
			e.getMessage();	
		}

	}
	
}



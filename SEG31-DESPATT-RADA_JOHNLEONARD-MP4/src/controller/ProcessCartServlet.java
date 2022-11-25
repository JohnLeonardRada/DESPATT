package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.*;

public class ProcessCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		
		try {		
			
			if(cvv.length() == 3 || cvv.length() == 4 && SingletonDB.Validate(ccn) == true) {		
				
				for(int i = 0; i<itemName.length; i++) {
					System.out.println("ITEMS:" + itemName[i]);
					
					String data_owner = owner;
					String data_itemName = itemName[i];
					String data_itemCount = count[i];
					String data_itemPrice = itemPrice[i];
					String data_itemImage = itemImage[i];
					int data_db_itemQuantity = SingletonDB.getItemQuantity(itemName[i]);
					
					SingletonDB.insertPurchase(data_owner, data_itemName, data_itemCount, data_itemPrice, data_itemImage);
					SingletonDB.updateQuantity(data_db_itemQuantity, Integer.parseInt(data_itemCount), data_itemName);
					System.out.println("Purchase Successful!");
					create.process();
				}
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

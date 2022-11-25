package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import model.camera.*;
import utility.*;
import view.Display;

public class PhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String searchPhone;
	
	public void init() throws ServletException {
		searchPhone = "";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			searchPhone = request.getParameter("searchPhone");

			Phone selpon = new PhoneFactory().getPhone(searchPhone.toUpperCase());
			Camera camera = new CameraFactory().getCamera(searchPhone);
			selpon.setCamera(camera);
			
			Display.viewDetails(selpon);
			request.setAttribute("searchPhone", selpon);
			request.setAttribute("results", selpon);

			SingletonDB.insertRecord(selpon, camera, getServletContext().getInitParameter("jdbcDriver"),
					getServletConfig().getInitParameter("jdbcUrl"), getServletConfig().getInitParameter("dbUserName"),
					getServletConfig().getInitParameter("dbUserPassword"));

			request.getRequestDispatcher("display.jsp").forward(request, response);
			
			CellphoneFactory prototype =  PhoneFactory.getPrototype(searchPhone.toUpperCase());
	        if (prototype != null) {
	            System.out.println(prototype.toString());
	        }
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			e.getMessage();
		}
		
	}
}

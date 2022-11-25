package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Phone phone = null;
		String searchPhone = request.getParameter("searchPhone");
		
		
		try {
			phone = (Phone) new PhoneFactory().getPhone(searchPhone.toUpperCase());
			Camera camera = new CameraFactory().getCamera(searchPhone);
			phone.setCamera(camera);
			Display.viewDetails(phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("searchPhone", searchPhone);
		request.setAttribute("results", phone);
		RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
		dispatcher.forward(request, response);
	}
}

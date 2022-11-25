package view;

import model.*;

public class Display {

	public static void print(Employee empleyado, String status) {
		System.out.println("\nEmployee Details - " + status);
		System.out.println("ID: " + empleyado.getEmpoyeeId());
		System.out.println("Name: " + empleyado.getEmployeeName());
		System.out.println("Department ID Assigned: " 
				+ empleyado.getDepartment().getId());
		System.out.println("Department Name: " 
			+ empleyado.getDepartment().getName());
	}
}

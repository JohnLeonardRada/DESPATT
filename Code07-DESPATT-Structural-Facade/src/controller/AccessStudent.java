package controller;

import model.StudenBean;

public class AccessStudent {

	public static void main(String[] args) {
		
		
		StudenBean student = new StudenBean("2011122232", 
			"James Gosling", 95, 90);
		
		
		/*student.determineRemarks();
		student.computeFinalGrade();
		student.print();*/
		student.process(); //this is an example of a facade method
		
	}
}

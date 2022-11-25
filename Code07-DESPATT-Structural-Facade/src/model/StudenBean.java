package model;

public class StudenBean implements Facade {

	//create instance variables
	//input values from the user
	private String id; //defaulted to null
	private String name; //defaulted to null
	private double midterm; //defaulted to 0.0
	private double preFinal;//defaulted to 0.0
	
	//computed values
	private double finalGrade; //defaulted to 0.0
	private String remarks; //defaulted to null
	
	public StudenBean() {
	}

	public StudenBean(String id, String name, double midterm, double preFinal) {
		this.id = id;
		this.name = name;
		this.midterm = midterm;
		this.preFinal = preFinal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMidterm() {
		return midterm;
	}

	public void setMidterm(double midterm) {
		this.midterm = midterm;
	}

	public double getPreFinal() {
		return preFinal;
	}

	public void setPreFinal(double preFinal) {
		this.preFinal = preFinal;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(double finalGrade) {
		this.finalGrade = finalGrade;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	private void computeFinalGrade() {
		this.finalGrade = this.midterm * 0.5 + this.preFinal * 0.5;
	}
	
	private void determineRemarks() {
		this.remarks = (this.finalGrade >= 69.5)
			? "Congratulations you passed."
			: "You have to re-enroll this subject next term.";		
	}
	
	public void print() {
		System.out.println("Printing Student Details" );
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Midterm Raw Grade: " + midterm);
		System.out.println("PreFinal Raw Grade: " + preFinal);
		System.out.println("FINAL: " + finalGrade);
		System.out.println("REMARKS: " + remarks);
		
		
	}
	
	@Override
	public void process() { //acts a facade
		computeFinalGrade();
		determineRemarks();
		print();
	}
}

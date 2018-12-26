package people;

import java.text.DecimalFormat;

public class Employee extends Person {
	DecimalFormat df = new DecimalFormat("0.00");
	private String office;
	private double salary;
	private Status status;
	
	
	/************************************
	 * Constructor: Employee()
	 * 				creates Employee object
	 * **********************************/
	public Employee(String name, int age, Status status, String office, double salary) {
		super(name, age);
		this.status = status;
		this.office = office;
		this.salary = salary;
	}
		
	/************************************
	 * Constructor: Employee()
	 * 				creates Employee object with name, age, office, and salary parameters
	 * **********************************/
	public Employee(String name, int age, String office, double salary) {
		super(name, age);
		this.office = office;
		this.salary = salary;
	}
	
	/************************************
	 * Constructor: Employee()
	 * 				creates Employee object
	 * **********************************/
	public Employee(String name, int age) {
		this(name, age, null, 0.0);
	}
	
	/************************************
	 * Constructor: Employee()
	 * 				creates Employee object with name and age parameters
	 * **********************************/
	public Employee(String name, String office, double salary) {
		this(name, 0, office, salary);
	}
	
	/************************************
	 * Constructor: Employee()
	 * 				creates Employee object 
	 * **********************************/
	public Employee(Person p, String office, double salary) {
		super(p.getName(), p.getAge());
		this.office = office;
		this.salary = salary;
	}
	
	/************************************
	 * Accessor:	getOffice()
	 * 				Returns Office
	 * **********************************/
	public String getOffice() {
		return office;
	}
	
	/************************************
	 * Accessor:	getSalary()
	 * 				Returns Salary
	 * **********************************/
	public double getSalary() {
		return salary;
	}
	
	/************************************
	 * Method:		payments()
	 * 				returns salary / 24
	 * **********************************/
	public double payments() {
		return salary / 24;
	}
	
	/************************************
	 * Method:		printStatus()
	 * 				Prints the object status
	 * **********************************/
	public void printStatus() {
		System.out.println("This is a College employee");
	}
	
	/************************************
	 * Method:		profile()
	 * 				Prints the object profile
	 * **********************************/
	public String profile() {
		return "Name:\t" + getName() + 
				"Age:\t" + getAge() + 
				"Status:\t" + status + "\n" +
				"Office:\t" + office + "\n" +
				"Salary:\t" + salary + "\n" +
				"Installments:\t" + payments();
	}
	
	/************************************
	 * Mutator:		setOffice()
	 * 				modifies the field Office
	 * **********************************/
	public void setOffice(String office) {
		this.office = office;
	}
	
	/************************************
	 * Mutator:		setSalary()
	 * 				modifies the field Salary
	 * **********************************/
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	/************************************
	 * Override:	toFile()
	 * 				returns a string with information in comma separated format
	 * **********************************/
	public String toFile() {
		return "Employee," + super.toFile() + "," + office 
											+ "," + salary;
	}
	
	/************************************
	 * Override:	toString()
	 * 				returns a string with all the fields
	 * **********************************/
	public String toString() {
		return "Employee\t" + super.toString() + "\tOffice: \t" + office + "\t" + 
								  					"Salary: \t" + salary;
	}
	
}

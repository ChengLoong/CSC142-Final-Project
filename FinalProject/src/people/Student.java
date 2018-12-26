package people;

public class Student extends Person {
	private double gpa;
	private Status status;
	
	/************************************
	 * Constructor: Student()
	 * 				prints an error message when no parameters are passed
	 * **********************************/
	public Student() {
		System.out.println("Error: no arguments passed");
	}
	
	/************************************
	 * Constructor: Student()
	 * 				creates a student object
	 * **********************************/
	public Student(String name, int age) {
		this(name, age, null, 0.0);
	}
	
	/************************************
	 * Constructor: Student()
	 * 				creates a student object
	 * **********************************/
	public Student(String name, int age, Status status, double gpa) {
//		setName(name);
//		setAge(age);
		super(name, age);
		this.status = status;
		this.gpa = gpa;
	}
	
	/************************************
	 * Constructor: Student()
	 * 				creates a student object
	 * **********************************/
	public Student(Person p) {
		super(p.getName(), p.getAge());
	}
	
	/************************************
	 * Constructor: Student()
	 * 				creates a student object
	 * **********************************/
	public Student(Person p, Status status, double gpa) {
		super(p.getName(), p.getAge());
		this.status = status;
		this.gpa = gpa;
	}
	
	/************************************
	 * Constructor: Student()
	 * 				creates a student object
	 * **********************************/
	public Student(Person p, double gpa, Status status) {
		super(p.getName(), p.getAge());
		this.status = status;
		this.gpa = gpa;
	}
	
	/************************************
	 * Constructor: Student()
	 * 				creates a student object
	 * **********************************/
	public Student(String name, int age, double gpa) {
		 this(name, age, null, gpa);
	}
	
	/************************************
	 * Constructor: Student()
	 * 				creates a student object
	 * **********************************/
	public Student(String name, Status status, double gpa) {
		 this(name, 0, status, gpa);
	}
	
	/************************************
	 * Constructor: Student()
	 * 				creates a student object
	 * **********************************/
	public Student(Status status, double gpa) {
		this(null, 0, status, gpa);
	}
	
	/************************************
	 * Accessor:	getGpa()
	 * 				Returns Gpa
	 * **********************************/
	public double getGpa() {
		return gpa;
	}
	
	/************************************
	 * Accessor:	getStatus()
	 * 				Returns status
	 * **********************************/
	public Status getStatus() {
		return status;
	}
	
	/************************************
	 * Method:		isOnProbation()
	 * 				Returns if the student is on probation
	 * **********************************/
	public boolean isOnProbation(double gpa) {
		return gpa < 2.0;
	}
	
	/************************************
	 * Method:		printStatus()
	 * 				Prints the object status
	 * **********************************/
	public void printStatus() {
		System.out.println("This is a College student");
	}
	
	/************************************
	 * Method:		profile()
	 * 				Prints the object profile
	 * **********************************/
	public String profile() {
		return "Name:\t" + getName() + 
				"Age:\t" + getAge() + 
				"Status:\t" + status + 
				"GPA:\t" + gpa;
	}

	/************************************
	 * Mutator:		setGpa()
	 * 				modifies the field Gpa
	 * **********************************/
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	/************************************
	 * Mutator:		setStatus()
	 * 				modifies the field Gpa
	 * **********************************/
	public void setStatus(Status status) {
		this.status = status;
	}
	
	/************************************
	 * Override:	toFile()
	 * 				returns a string with information in comma separated format
	 * **********************************/
	public String toFile() {
		return "Student," + super.toFile() 	+ "," + status 
											+ "," + gpa;
	}
	
	/************************************
	 * Override:	toString()
	 * 				Returns a string with all the fields
	 * **********************************/
	public String toString() {
		return 	"Student\t\t" 	+ super.toString() + 
				"\tStatus: \t" 	+ (status + "    ").substring(0,9) 	
								+ "\t" 	+ "GPA: \t\t" + gpa;
	}

}
